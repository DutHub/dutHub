package com.duthub.DutHub.bll.services;

import com.duthub.DutHub.bll.exceptions.ItemNotFoundException;
import com.duthub.DutHub.bll.interfaces.IEvaluationService;
import com.duthub.DutHub.dao.domain.Dislike;
import com.duthub.DutHub.dao.domain.Like;
import com.duthub.DutHub.dao.repo.DislikeRepository;
import com.duthub.DutHub.dao.repo.LikeRepository;
import com.duthub.DutHub.dao.repo.UserRepository;
import com.duthub.DutHub.dao.repo.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService implements IEvaluationService {
    private LikeRepository likeRepository;
    private DislikeRepository dislikeRepository;
    private UserRepository userRepository;
    private VideoRepository videoRepository;

    public void likeVideo(Long videoId, String userId) {
        likeRepository.save(new Like(
                userRepository.findById(userId).orElseThrow(ItemNotFoundException::new),
                videoRepository.findById(videoId).orElseThrow(ItemNotFoundException::new)
        ));
    }


    public void dislikeVideo(Long videoId, String userId) {
        dislikeRepository.save(new Dislike(
                userRepository.findById(userId).orElseThrow(ItemNotFoundException::new),
                videoRepository.findById(videoId).orElseThrow(ItemNotFoundException::new)
        ));
    }


    public void removeLike(Long videoId, String userId) {
        likeRepository.delete(new Like(
                userRepository.findById(userId).orElseThrow(ItemNotFoundException::new),
                videoRepository.findById(videoId).orElseThrow(ItemNotFoundException::new)
        ));
    }


    public void removeDislike(Long videoId, String userId) {
        dislikeRepository.delete(new Dislike(
                userRepository.findById(userId).orElseThrow(ItemNotFoundException::new),
                videoRepository.findById(videoId).orElseThrow(ItemNotFoundException::new)
        ));
    }


    public void addView(Long videoId) {
        videoRepository.findById(videoId).orElseThrow(ItemNotFoundException::new).addView();
    }
}
