package com.duthub.DutHub.bll.interfaces;

import com.duthub.DutHub.bll.domain.create.VideoNew;
import com.duthub.DutHub.bll.domain.dto.VideoDto;
import com.duthub.DutHub.bll.domain.update.VideoUpdate;
import com.duthub.DutHub.bll.exceptions.ItemNotFound;
import com.duthub.DutHub.dao.domain.Video;

import java.util.List;

public interface IVideoService {
    List<VideoDto> findAll();
    VideoDto findById(Long id) throws ItemNotFound;
    List<VideoDto> findMostPopular(int amount);
    VideoDto create(VideoNew video) throws ItemNotFound;
    VideoDto update(Long id, VideoUpdate video) throws ItemNotFound;
    void remove(Long id) throws ItemNotFound;
}
