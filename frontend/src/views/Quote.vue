<template>

    <div>
        <h1>Quotes</h1>
        <ul>
            <li v-for="(quote, index) in quotes" :key="index">{{quote}}</li>
        </ul>

    </div>

</template>


<script>

import FinSecService from '@/services/FinSecService.js';

export default {
    
    name: "Quote",

    props: ['symbol'],

    data() {
        return {
           quotes: []
        }
    },

    created() {

        FinSecService.getQuote(this.symbol)
        .then(response => {
            this.quotes = response.data
        })
        .catch(error => {
            console.log('There was an error in quote lookup:', error.response);
        });

    }

}

</script>