const Establishments = { template: '<establishments></establishments>' };
const AddEstablishment = {template: '<addest></addest>'};
const Establishment = {template: '<establishment></establishment>'};

const router = new VueRouter({
	mode: 'hash',
	  routes: [
		{ path: '/', name: 'home', component: Establishments},
		{ path: '/Add/', name: 'Addition',component: AddEstablishment},
		{ path: '/:name', name: 'Establishment',component: Establishment}
	  ]
});

var app = new Vue({
	router,
	el: '#establishments'
});