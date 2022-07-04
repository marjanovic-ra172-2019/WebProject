Vue.component("addest", { 
	data: function () {
		var Data
	    return {
		  register:null,
	      establishment: {name:null,type:null,trainings:null,open:false,location:null,averageGrade:0.0,workingHours:null},
	      showEmptyMessage: false,
		  selected: '',
		  types: [
      		{id: 'GYM', name: 'Teretana'},
      		{id: 'POOL', name: 'Bazen'},
     	 	{id: 'SPORTSCENTER', name: 'Sportski Centar'},
     	 	{id: 'DANCESTUDIO', name: 'Dance studio'}
    		]
    	
	    }
	},
	    template: ` 
    	<div>
    		<h1>Addition of new establishment</h1>
    		
    		<table>
			<tr><td>Ime</td><td><input type="text" v-model = "establishment.name" name="name"></td></tr>
			<tr><td>Tip ustanove</td><td>
			<select v-model="selected">
       			<option v-for="type in types" v-bind:value="{ id: type.id, text: type.name }">{{ type.name }}
       			</option>
   				</select>
   				</td></tr>
			
			<tr><td>Location</td><td><input type="text" v-model = "establishment.location" name="location"></td></tr>
			<tr><button v-on:click="Register">Register</button></tr>

			</table>

    	
	    	<div v-show="showEmptyMessage">
	    		<label>Nema nijedan koji odgvara pretrazi</label>
	    	</div>
    	</div>		  
    	`,
    mounted () {
       
    },
    methods : {
		Register: function(){
				event.preventDefault();
						    
				
				this.establishment.type=this.selected.id;
					
					
				axios.post('rest/establishments/addest/', this.establishment).
				then(response => (this.register=response.data));
;
					//router.push(`/`);
				return;
					
			}	
		
	}
   
});