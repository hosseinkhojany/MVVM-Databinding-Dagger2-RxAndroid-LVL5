package james_gosling.projects.kotlin_mvvm.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;
import james_gosling.projects.kotlin_mvvm.data.model.db.User;

@Dao
public interface UserDao {

    @Delete
    void delete(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> user);

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    Single<User> findByName(String name);

    @Query("SELECT * FROM users")
    Single<List<User>> getAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    Single<List<User>> getAllByIds(List<User> userIds);




}
