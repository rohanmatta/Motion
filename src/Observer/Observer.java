package Observer;

import Model.TrackProgress.ProgressData;

public interface Observer {
    void update(ProgressData progressData);
}


