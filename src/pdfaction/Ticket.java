package pdfaction;

/**
 * 
 * Copyright © 2017RUIDA. All rights reserved.
 * 
 * @ClassName: Ticket
 * @Description: TODO
 * @author: SZL
 * @date: 2017年12月25日 下午1:16:54
 */
public class Ticket {

	private String school;
	private String name;
	private String classes;
	private String topic;

	public Ticket() {
		super();
	}

	public Ticket(String school, String name, String classes, String topic) {
		this.school = school;
		this.name = name;
		this.classes = classes;
		this.topic = topic;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
