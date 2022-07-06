Vue.component("establishments", { 
	data: function () {
		var Data
	    return {
		  sort_direction: 'desc',
		  sort_field: 'created_at',
	      establishments: null,
	      establishment: {name: null, type:null, grade:null},
	      showEmptyMessage: false,
		  selected: '',
		  products: [
      		{id: 'name', name: 'ime'},
      		{id: 'type', name: 'tip'},
     	 	{id: 'address', name: 'Adresa'},
     	 	{id: 'grade', name: 'Prosecna ocena'}
    		]
	    }
	},
	    template: ` 
    	<div>
    		<h3>Prikaz ustanova</h3>
    		
			<input type = "text" v-model = "establishment.name" name = "name">
			<button v-on:click="Search_bar">Pretrazi</button>
 			<select v-model="selected">
       			<option v-for="product in products" v-bind:value="{ id: product.id, text: product.name }">{{ product.name }}
       			</option>
   				</select>
    		<table border="1">
	    		<tr bgcolor="lightgrey">
	    			<th>
	    			<a href="#" @click.prevent="change_sort('name')">Naziv</a>
	    			<span>&uarr;</span>
	    			<span>&darr;</span>
	    			</th>
	    			<th>
	    			<a href="#" @click.prevent="change_sort('type')">Tip</a>
	    			<span>&uarr;</span>
	    			<span>&darr;</span>
	    			</th>
	    			<th>
	    			<a href="#" @click.prevent="change_sort('location')">Adresa</a>
	    			<span>&uarr;</span>
	    			<span>&darr;</span>
	    			</th>
	    			<th>
	    			<a href="#" @click.prevent="change_sort('averagegrade')">Prosecna ocena</a>
	    			<span>&uarr;</span>
	    			<span>&darr;</span>
	    			</th>
	    		</tr>
	    			
	    		<tr v-for="p in establishments">
	    			<td><a :href="'establishments.html#/'+p.name">{{p.name}}</a></td>
	    			<td>{{p.type}}</td>
	    			<td>{{p.location.name}} {{p.location.number}}</td>
	    			<td>{{p.averageGrade}}</td>
	    		</tr>

	    	</table>
	    	
	    	<button v-on:click="ShowOpen">Prikazi Otvorene</button>

	    	<div v-show="showEmptyMessage">
	    		<label>Nema nijedan koji odgvara pretrazi</label>
	    	</div>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/establishments/')
          .then(response => (this.establishments = response.data))
    },
    methods : {
		Search_bar : function () {
			event.preventDefault();
			
			if(this.establishment.name===null){return};
			
			if(this.establishment.name===""){
				this.showEmptyMessage=false;
				axios
		          .get('rest/establishments/')
		          .then(response => (this.establishments = response.data));
				return;
			}
			
			if(this.selected.id=="name"){
				axios
				.get('rest/establishments/name/'+this.establishment.name)
				.then(response => (this.establishments = response.data));
				} else
			if(this.selected.id=="type"){
				axios
				.get('rest/establishments/type/'+this.establishment.name)
				.then(response => (this.establishments = response.data));
				} else
			if(this.selected.id=="address"){
				axios
				.get('rest/establishments/address/'+this.establishment.name)
				.then(response => (this.establishments = response.data));
				} else
			if(this.selected.id=="grade"){
				axios
				.get('rest/establishments/grade/'+this.establishment.name)
				.then(response => (this.establishments = response.data));
				}
			if(this.establishments.length==0)
			{
				this.showEmptyMessage=true;
				return;
			}else
				this.showEmptyMessage=false;
				return;
			},
		ShowOpen:function(){
			event.preventDefault();
				axios
				.get('rest/establishments/open/')
				.then(response => (this.establishments = response.data))
			return;
		},
		change_sort(field)
		{
			if(this.sort_field==field)
			{
				this.sort_direction=="asc"?"desc":"asc";
			}else
			{
				this.sort_field=field;
				this.sort_direction="desc";
			}
			axios.
			get('rest/establishments/'+this.sort_field+'&'+this.sort_direction)
			.then(response => (this.establishments = response.data));		
		}
		
	}
   
    
});