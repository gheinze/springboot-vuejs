<template>

    <div>
        <h1>Exchanges</h1>
        <ul>
            <li v-for="(exchange, index) in exchanges" :key="index">{{exchange}}</li>
        </ul>

    </div>

</template>


<script>

import FinSecService from '@/services/FinSecService.js';

export default {
    
    name: "Exchange",

    data() {
        return {
           exchanges: []
        }
    },

    created() {

        FinSecService.getExchanges()
        .then(response => {
            this.exchanges = response.data
        })
        .catch(error => {
            console.log('There was an error in looking up the list of exchanges:', error.response);
        });

    }

}

</script>