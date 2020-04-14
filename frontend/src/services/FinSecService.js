import axios from 'axios';
    
const apiClient = axios.create({  
    baseURL: `http://localhost:8080/api/finsec`,
    withCredentials: false,
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
    }
});


export default {
    getQuote(symbol) {
        return apiClient.get('/quotes/' + symbol);
    }
}