package com.hazeldev.holidaytripbackend.models.requestModels;

import javax.validation.constraints.NotNull;

public class UpdateCheckpointLocationRequest {

    @NotNull
    private Integer checkpointId;
    @NotNull
    private Double latitude;
    @NotNull
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
