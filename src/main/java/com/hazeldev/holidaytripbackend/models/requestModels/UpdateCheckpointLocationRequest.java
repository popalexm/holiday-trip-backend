package com.hazeldev.holidaytripbackend.models.requestModels;

public class UpdateCheckpointLocationRequest {

    private Integer checkpointId;
    private Double latitude;
    private Double longitude;

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
