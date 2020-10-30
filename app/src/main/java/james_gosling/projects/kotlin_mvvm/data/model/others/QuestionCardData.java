package james_gosling.projects.kotlin_mvvm.data.model.others;

import java.util.List;

import james_gosling.projects.kotlin_mvvm.data.model.db.Option;
import james_gosling.projects.kotlin_mvvm.data.model.db.Question;

public class QuestionCardData {

    public boolean mShowCorrectOptions;

    public List<Option> options;

    public Question question;

    public QuestionCardData(Question question, List<Option> options) {
        this.question = question;
        this.options = options;
    }
}
