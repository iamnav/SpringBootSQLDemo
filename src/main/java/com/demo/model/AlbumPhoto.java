package com.demo.model;

/***
 * The AlbumPhoto Model class.
 * 
 * @author iamnav
 *
 */
public class AlbumPhoto {
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;

	/** Getters and Setters */
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/** toString */
	@Override
	public String toString() {
		return "AlbumPhoto [albumId=" + albumId + ", id=" + id + ", title=" + title + ", url=" + url + ", thumbnailUrl="
				+ thumbnailUrl + "]";
	}
}
