package com.duthub.DutHub.bll.interfaces;

import com.duthub.DutHub.bll.domain.create.VideoNew;
import com.duthub.DutHub.bll.domain.dto.VideoDto;
import com.duthub.DutHub.bll.domain.update.VideoUpdate;
import com.duthub.DutHub.bll.exceptions.ItemNotFoundException;

import java.util.List;

public interface IVideoService {
    List<VideoDto> findAll();
    VideoDto findById(Long id) throws ItemNotFoundException;
    List<VideoDto> findMostPopular(int amount);
    VideoDto create(VideoNew video) throws ItemNotFoundException;
    VideoDto update(Long id, VideoUpdate video) throws ItemNotFoundException;
    void remove(Long id) throws ItemNotFoundException;
}
