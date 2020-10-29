package james_gosling.projects.kotlin_mvvm.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import io.reactivex.Single;
import james_gosling.projects.kotlin_mvvm.data.model.db.Option;

@Dao
public interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Option option);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Option> option);

    @Query("SELECT * FROM options")
    Single<List<Option>> getAll();

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    Single<List<Option>> getAllByQuestionQuery(Long questionId);

}
