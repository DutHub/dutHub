package com.duthub.DutHub.bll.services;

import com.duthub.DutHub.bll.domain.create.VideoNew;
import com.duthub.DutHub.bll.domain.dto.VideoDto;
import com.duthub.DutHub.bll.domain.update.VideoUpdate;
import com.duthub.DutHub.bll.exceptions.ItemNotFound;
import com.duthub.DutHub.bll.interfaces.IVideoService;
import com.duthub.DutHub.dao.domain.User;
import com.duthub.DutHub.dao.domain.Video;
import com.duthub.DutHub.dao.repo.UserRepository;
import com.duthub.DutHub.dao.repo.VideoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService implements IVideoService {
    private VideoRepository repository;
    private UserRepository userRepository;

    public List<VideoDto> findAll() {
        return repository.findAll().stream().map(VideoDto::new).collect(Collectors.toList());
    }

    public VideoDto findById(Long id) throws ItemNotFound {
        return new VideoDto(repository.findById(id).orElseThrow(ItemNotFound::new));
    }

    public List<VideoDto> findMostPopular(int amount) {
        List<Video> result = repository.findAll();
        result.sort((el1, el2) -> el1.getViews() >= el2.getViews() ? 1 : -1);
        return result.subList(0, amount).stream().map(VideoDto::new).collect(Collectors.toList());
    }

    public VideoDto create(VideoNew video) throws ItemNotFound {
        User user = userRepository.findById(video.getUserId()).orElseThrow(ItemNotFound::new);
        Video videoDb = new Video();

        videoDb.setUser(user);
        videoDb.setTitle(video.getTitle());
        videoDb.setDescription(video.getDescription());
        videoDb.setVideoPath(video.getVideoPath());
        videoDb.setPreviewPath(video.getPreviewPath());
        videoDb.setCreationDate(LocalDateTime.now());
        videoDb.setViews(0);

        return new VideoDto(repository.save(videoDb));
    }

    public VideoDto update(Long id, VideoUpdate video) throws ItemNotFound {
        Video videoDb = repository.findById(id).orElseThrow(ItemNotFound::new);

        videoDb.setTitle(video.getTitle());
        videoDb.setDescription(video.getDescription());
        videoDb.setPreviewPath(video.getPreviewPath());
        return new VideoDto(repository.save(videoDb));
    }

    public void remove(Long id) throws ItemNotFound {
        if (repository.existsById(id))
            throw new ItemNotFound();
        repository.deleteById(id);
    }
}
