package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Album;
import com.demo.model.AlbumPhoto;
import com.demo.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	// Populates the 'album' and 'photo' tables
	@GetMapping("/insert-albums")
	public void insertAlbums() {
		albumService.insertAllAlbums();
	}

	// Search for a album
	@GetMapping(path = "/search/{type}/{id}")
	public List<Album> getAllAlbumsById(@PathVariable String type, @PathVariable Integer id) {
		return albumService.getAllAlbumsById(id);
	}

	// Search for a album photo
	@GetMapping(path = "/search/{type}/{albumId}/{id}")
	public List<AlbumPhoto> getAllAlbumPhotosByAlbumAndId(@PathVariable String type, @PathVariable Integer albumId,
			@PathVariable Integer id) {
		return albumService.getAllAlbumPhotosByAlbumAndId(albumId, id);
	}

	// Health Check URL
	@GetMapping("/health")
	private String healthCheck() {
		return "Service is up!";
	}
}
