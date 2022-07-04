Vue.component("addest", { 
	data: function () {
		var Data
	    return {
		
	      establishments: null,
	      establishment: {name: null, type:null,location:null},
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
			
			</table>

    	
	    	<div v-show="showEmptyMessage">
	    		<label>Nema nijedan koji odgvara pretrazi</label>
	    	</div>
    	</div>		  
    	`,
    mounted () {
       
    },
    methods : {
		
		
	}
   
});