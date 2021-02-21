package com.duthub.DutHub.bll.interfaces;

public interface IEvaluationService {
    void likeVideo(Long videoId, String userId);
    void dislikeVideo(Long videoId, String userId);
    void removeLike(Long videoId, String userId);
    void removeDislike(Long videoId, String userId);
    void addView(Long videoId);
}
