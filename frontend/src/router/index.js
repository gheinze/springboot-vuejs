import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Quote from "../views/Quote.vue";
import Exchange from "../views/Exchange.vue";
import FinSecDebentures from "@/views/FinSecDebentures";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/quote",
    name: "Quote",
    component: Quote
  },
  {
    path: "/exchange",
    name: "Exchange",
    component: Exchange
  },
  {
    path: '/debentures',
    name: "Debentures",
    component: FinSecDebentures
  }
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
