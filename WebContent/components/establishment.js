Vue.component("establishment", {
	data: function () {
		    return {
			  name : null,
	      	  establishment: {name:null,type:null,trainings:null,open:false,location:null,averageGrade:0.0,workingHours:{startTime:null,endTime:null}},
		      
		    }
	},
	template: ` 
<div>
	{{title}}
	<table>
			<tr><td>Ime</td><td><input type="text" v-model = "establishment.name" name="name"></td></tr>
			<tr><td>Tip ustanove</td><td><input type="text" v-model = "establishment.type" name="type"></td></tr>
			
			<tr><td>Location</td><td><input type="text" v-model = "establishment.location.name + establishment.location.number" name="location"></td></tr>
			<tr><td>StartTime</td><td><input type="text" v-model = "establishment.workingHours.startTime" name="startTime"></td></tr>
			<tr><td>EndTime</td><td><input type="text" v-model = "establishment.workingHours.endTime" name="endTime"></td></tr>
			<tr>ALL Trainings</tr>
			<tr v-for="p in establishment.trainings">
	    			<td>{{p}}</td>
	    	</tr>
			</table>
</div>		  
`
	, 
	methods : {
		
	},
	mounted () {
		this.name = this.$route.params.name;
		if(this.name==null){router.push(`/`);}
	        axios
	          .get('rest/establishments/' + this.name)
	          .then(response => (this.establishment = response.data))
		
    }
});