package kr.spring.map.domain;

import java.sql.Date;

public class MapleadVO {
	private int map_num;
	private String name;
	private String map_address;
	private String map_content;
	private Date reg_date;
	private Date mod_date;
	public int getMap_num() {
		return map_num;
	}
	public void setMap_num(int map_num) {
		this.map_num = map_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMap_address() {
		return map_address;
	}
	public void setMap_address(String map_address) {
		this.map_address = map_address;
	}
	public String getMap_content() {
		return map_content;
	}
	public void setMap_content(String map_content) {
		this.map_content = map_content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	
}
