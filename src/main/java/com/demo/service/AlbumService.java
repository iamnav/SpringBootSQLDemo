package com.demo.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.AlbumMapper;
import com.demo.mapper.AlbumPhotoMapper;
import com.demo.model.Album;
import com.demo.model.AlbumPhoto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * The AlbumService class.
 * 
 * @author iamnav
 *
 */
@Service
public class AlbumService {

	@Autowired
	private AlbumMapper albumMapper;

	@Autowired
	private AlbumPhotoMapper albumPhotoMapper;

	/***
	 * The insert all albums method. Populates the tables.
	 */
	public void insertAllAlbums() {
		// GET call to the album API
		String albumUrl = "https://jsonplaceholder.typicode.com/albums";
		String albumPhotoUrl = "https://jsonplaceholder.typicode.com/photos?albumId=";
		String tempUrl;

		List<Album> albumList = new ArrayList<>();
		List<AlbumPhoto> albumPhotoList = new ArrayList<>();

		try {
			URL url = new URL(albumUrl);
			albumList = new ObjectMapper().readValue(url, new TypeReference<List<Album>>() {
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Insert each object into db
		for (Album album : albumList) {
			int userId = album.getId();
			albumMapper.insert(album);
			tempUrl = albumPhotoUrl + "" + userId;

			try {
				URL url = new URL(tempUrl);
				albumPhotoList = new ObjectMapper().readValue(url, new TypeReference<List<AlbumPhoto>>() {
				});
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			for (AlbumPhoto albumPhoto : albumPhotoList) {
				albumPhotoMapper.insert(albumPhoto);
			}
		}
	}

	/**
	 * The get all albums by Id method.
	 * 
	 * @param id
	 * @return
	 */
	public List<Album> getAllAlbumsById(Integer id) {
		return albumMapper.findAllById(id);
	}

	/***
	 * The get all album photos by album Id and Id method.
	 * 
	 * @param albumId
	 * @param id
	 * @return
	 */
	public List<AlbumPhoto> getAllAlbumPhotosByAlbumAndId(Integer albumId, Integer id) {
		return albumPhotoMapper.findAllByAlbumIdAndId(albumId, id);
	}
}
