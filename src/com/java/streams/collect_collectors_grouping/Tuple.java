package com.java.streams.collect_collectors_grouping;


public class Tuple {
	
//	enum BlogPostType {
//	    NEWS,
//	    REVIEW,
//	    GUIDE
//	}
	
    public Tuple(BlogPostType type, String author) {
		super();
		this.type = type;
		this.author = author;
	}
    
    
	BlogPostType type;
    String author;
    
    
	public BlogPostType getType() {
		return type;
	}
	public void setType(BlogPostType type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
    
    
}
	
