Vue.component("register", { 
	data: function () {
	    return {
		  Data:null,
	      showEmptyMessage2: false,
	      register: null,
	      user1: {username: null,password: null,name:null,lastName:null,gender:'FEMALE',dateOfBirth:null,role:'CUSTOMER'},
	      showEmptyMessage: false,
	       selected: '',
	       products: [
      		{id: 'MALE', name: 'muski'},
      		{id: 'FEMALE', name: 'zenski'}
    		]
	    }
	      
	      
	      
	},
	template:
	`<div>
			<table>
			<tr><td>Username</td><td><input type="text" v-model = "user1.username" name="username"></td></tr>
			<tr><td>Password</td><td><input type="password" v-model = "user1.password" name="password"></td></tr>
			<tr><td>ime</td><td><input type="text" v-model = "user1.name" name="name"></td></tr>
			<tr><td>Prezime</td><td><input type="text" v-model = "user1.lastName" name="lastname"></td></tr>
			<tr><td>Pol</td><td>
			<select v-model="selected">
       			<option v-for="product in products" v-bind:value="{ id: product.id, text: product.name }">{{ product.name }}
       			</option>
   				</select>
   				</td></tr>
   				<tr><button v-on:click="Register">Register</button></tr>
			
			</table>
			<div v-show="showEmptyMessage">
			<label>you haven't filled the form'</label>
	    	</div>
	    	<div v-show="Data">
	    	<label>Username is taken</label>
	    	</div>


	</div>`,
	    methods : 
	    {
			Register: function(){
				event.preventDefault();
				if(this.user1.username===null||this.user1.password===null||this.user1.name===null||this.user1.lastname===null)
				{
					this.showEmptyMessage=true;
					return;
				}
					this.user1.gender=this.selected.id;
				    this.showEmptyMessage=false;
				    axios.get('rest/username/'+ this.user1.username).
					then(response => (this.Data=response.data));
					
					if(this.Data===false)
					{
						axios.post('rest/addition/', this.user1).
						then(response => (this.register=response.data));
						router.push(`/`);
						return;
					}
			}		
		}

});