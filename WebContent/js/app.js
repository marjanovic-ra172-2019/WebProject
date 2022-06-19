const Establishments = { template: '<establishments></establishments>' }

const router = new VueRouter({
	mode: 'hash',
	  routes: [
		{ path: '/', name: 'home', component: Establishments},
	  ]
});

var app = new Vue({
	router,
	el: '#establishments'
});