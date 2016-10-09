package springMongo;

import org.springframework.data.annotation.Id;

public class Entity {

    @Id
    public String id;

    private String content;
    private int favoriteNumber;

    public Entity() {}

    public Entity(String content, int favoriteNumber) {
        this.content = content;
        this.favoriteNumber = favoriteNumber;
    }

	/**
	* Returns value of id
	* @return
	*/
	public String getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	* Returns value of content
	* @return
	*/
	public String getContent() {
		return content;
	}

	/**
	* Sets new value of content
	* @param
	*/
	public void setContent(String content) {
		this.content = content;
	}

	/**
	* Returns value of favoriteNumber
	* @return
	*/
	public int getFavoriteNumber() {
		return favoriteNumber;
	}

	/**
	* Sets new value of favoriteNumber
	* @param
	*/
	public void setFavoriteNumber(int favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
}
