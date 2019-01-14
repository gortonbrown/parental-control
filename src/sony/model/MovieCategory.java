package sony.model;

public enum MovieCategory {
	U,
	PG,
	Twelve,
	Fifteen,
	Eighteen;
	
	public String getMovieCategory() {
		return getRating(this);
	}
	
	private String getRating(MovieCategory movieCategory) {
		switch(movieCategory.name()){
			case "Twelve" :
				return "12";
			case "Fifteen" :
				return "15";
			case "Eighteen" :
				return "18";
		} 
		
		return movieCategory.name();
	}
}