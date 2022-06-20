const Login = { template: '<login></login>'}
const Register = {template: '<register></register>'}

const router = new VueRouter({
	mode: 'hash',
	  routes: [
		{ path: '/', name: 'home', component: Login},
		{ path: '/register/', name:'register',component:Register}
	  ]
});

var app = new Vue({
	router,
	el: '#login'
});