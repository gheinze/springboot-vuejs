<style scoped>
    .expand-row{
        margin-bottom: 16px;
    }
    .divider{
        width:5px;
        height:auto;
        display:inline-block;
    }
</style>


<template>

    <div>

        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">Rate: </span>
                <InputNumber v-model="editPercentage" v-if="editMode" placeholder="percentage" style="width: 100px" />
                <span v-else class="expand-value">{{ row.percentage }}%</span>
            </Col>
            <Col span="8">
                <span class="expand-key">Issue date: </span>
                <DatePicker type="date" v-if="editMode" v-model="editIssueDte" style="width: 150px"></DatePicker>
                <span v-else class="expand-value">{{ row.issueDte }}</span>
            </Col>
            <Col span="8" align="right">
                <span v-if="editMode">
                    <Button type="primary" @click="saveHandler(row)">Save</Button>
                     <div class="divider"/>
                    <Button type="error" @click="cancelHandler(row)">Cancel</Button>
                </span>
                <Button v-else type="primary" @click="editHandler(row)">Edit</Button>
            </Col>
        </Row>

        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">Underlying: </span>
                <Input v-model="editUnderlyingSymbol" v-if="editMode" placeholder="symbol" style="width: 100px" />
                <span v-else class="expand-value">{{ row.underlyingSymbol }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">Close: </span>
                <span class="expand-value">{{ row.underlyingClosePrice }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">Read Date: </span>
                <span class="expand-value">{{ row.underlyingReadDte }}</span>
            </Col>
        </Row>

        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">Conversion Price: </span>
                <InputNumber v-model="editConversionPrice" v-if="editMode" style="width: 100px" />
                <span v-else class="expand-value">${{ row.conversionPrice }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">Conversion Rate: </span>
                <InputNumber v-model="editConversionRate" v-if="editMode" style="width: 100px" />
                <span v-else class="expand-value">{{ row.conversionRate }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">Converted: </span>
                <span class="expand-value">${{ row.converted }}</span>
            </Col>
        </Row>

        <Row class="expand-row">
            <Col>
                <span class="expand-key">Prospectus: </span>
                <Input type="url" v-model="editProspectus" v-if="editMode" style="width: 800px" />
                <a v-else v-bind:href="row.prospectus" target="_blank">{{ row.prospectus }}</a>
            </Col>
        </Row>

        <Row class="expand-row">
            <Col>
                <Input type="text" v-model="editComments" placeholder="comments" v-if="editMode" style="width: 800px" />
                <p v-else>{{ row.comments }}</p>
            </Col>
        </Row>

        <Row>
            <Col span="8">
                <sparkline>
                    <sparklineLine :refLineType="parLineType" :refLineProps="parLineValue" :data="closePrice" :limit="closePrice.length" :styles="spLineStyles1" />
                </sparkline>
            </Col>

            <Col span="8">
                <sparkline>
                    <sparklineBar
                            :data="volumeTraded"
                            :margin="spMargin4"
                            :limit="volumeTraded.length"
                            :styles="volumeBarStyle"
                            :refLineStyles="spRefLineStyles4" />
                </sparkline>
            </Col>


        </Row>

    </div>

</template>


<script>

    // http://www.7te.net/zp-ui/#/sparkline

    import FinSecService from '@/services/FinSecService.js';


    export default {

        props: {
            row: Object
        },

        data() {
            return {

                closePrice: [],
                spIndicatorStyles1: false,
                spLineStyles1: {
                    stroke: '#54a5ff'
                },
                parLineType: 'ustom',
                parLineValue: {value: '100'},

                volumeTraded: [],
                spMargin4: 2,
                volumeBarStyle: {
                    fill: '#54a5ff'
                },
                spLineStyles4: {
                    stroke: '#d14'
                },
                spRefLineStyles4: {
                    stroke: '#d14',
                    strokeOpacity: 1,
                    strokeDasharray: '3, 3'
                },

                editMode: false,

                editPercentage: '',
                editIssueDte: null,
                editUnderlyingSymbol: '',
                editConversionPrice: '',
                editConversionRate: '',
                editProspectus: '',
                editComments: ''

            }
        },

        mounted: function() {
            this.getQuoteHistory(this.row.instrumentId);
        },


        methods: {

            getQuoteHistory: function (instrumentId) {
                FinSecService.getQuoteHistory(instrumentId).then(restResponse => {
                    this.loading = true;
                    this.closePrice = restResponse.data.map(q => q.closePrice);
                    this.volumeTraded = restResponse.data.map(q => q.volumeTraded);
                    this.loading = false;
                });

            },

            editHandler: function(row) {

                this.editPercentage = row.percentage;
                this.editIssueDte = row.issueDte;
                this.editUnderlyingSymbol = row.underlyingSymbol;
                this.editConversionPrice = row.conversionPrice;
                this.editConversionRate = row.conversionRate;
                this.editProspectus = row.prospectus;
                this.editComments = row.comments;

                this.editMode = !this.editMode;
            },

            saveHandler: function(row) {

                let model = {
                    percentage: this.editPercentage,
                    issueDte: this.editIssueDte,
                    underlyingSymbol: this.editUnderlyingSymbol,
                    conversionPrice: this.editConversionPrice,
                    conversionRate: this.editConversionRate,
                    prospectus: this.editProspectus,
                    comments: this.editComments
                };

                FinSecService.saveDebentureDetails(row.instrumentId, model);

                row.percentage = this.editPercentage;
                row.issueDte = this.editIssueDte;
                row.underlyingSymbol = this.editUnderlyingSymbol;
                row.conversionPrice = this.editConversionPrice;
                row.conversionRate = this.editConversionRate;
                row.prospectus = this.editProspectus;
                row.comments = this.editComments;

                this.editMode = !this.editMode;
            },

            cancelHandler: function(row) {
                this.editMode = !this.editMode;
            }


        }

    };

</script>