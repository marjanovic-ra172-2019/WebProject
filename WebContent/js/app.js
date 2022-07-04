const Establishments = { template: '<establishments></establishments>' };
const AddEstablishment = {template: '<addest></addest>'};


const router = new VueRouter({
	mode: 'hash',
	  routes: [
		{ path: '/', name: 'home', component: Establishments},
		{ path: '/Add/', name: 'Addition',component: AddEstablishment}
	  ]
});

var app = new Vue({
	router,
	el: '#establishments'
});