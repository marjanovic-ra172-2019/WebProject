Vue.component("establishments", { 
	data: function () {
	    return {
	      establishments: null
	    }
	},
	    template: ` 
    	<div>
    		<h3>Prikaz ustanova</h3>
    		<table border="1">
	    		<tr bgcolor="lightgrey">
	    			<th>Naziv</th>
	    			<th>Tip</th>
	    			<th>Adresa</th>
	    			<th>Prosecna ocena</th>
	    		</tr>
	    			
	    		<tr v-for="p in establishments">
	    			<td>{{p.name}}</td>
	    			<td>{{p.type}}</td>
	    			<td>{{p.location.name}} {{p.location.number}}</td>
	    			<td>{{p.averageGrade}}</td>
	    		</tr>
	    	</table>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/establishments/')
          .then(response => (this.establishments = response.data))
    },
   
    
});