package james_gosling.projects.kotlin_mvvm.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Experimental;

@Entity(tableName = "options",
        foreignKeys = @ForeignKey(
                entity = Question.class,
                parentColumns = "id",
                childColumns = "question_id"
        )
)
public class Option {


    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    public boolean isCorrect;

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "option_text")
    public String optionText;

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id")
    public Long QuestionId;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String UpdatedAt;

}
