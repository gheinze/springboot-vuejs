import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import ViewUI from 'view-design';
import locale from 'view-design/dist/locale/en-US';
import 'view-design/dist/styles/iview.css';
import Sparkline from 'vue-sparklines'

Vue.use(ViewUI, { locale });
Vue.use(Sparkline);

Vue.config.productionTip = false;


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
