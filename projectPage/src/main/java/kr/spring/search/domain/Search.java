package kr.spring.search.domain;

public class Search {
	private String car_name;
	private String car_make;
	private String car_keyword;
	
	public Search() {}
	

	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_make() {
		return car_make;
	}
	public void setCar_make(String car_make) {
		this.car_make = car_make;
	}
	
	public String getCar_keyword() {
		return car_keyword;
	}
	public void setCar_keyword(String car_keyword) {
		this.car_keyword = car_keyword;
	}


	@Override
	public String toString() {
		return "Search [car_name=" + car_name + ", car_make=" + car_make + ", car_keyword=" + car_keyword + "]";
	}

	
}
