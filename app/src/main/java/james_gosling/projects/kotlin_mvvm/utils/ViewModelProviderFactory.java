package james_gosling.projects.kotlin_mvvm.utils;

import androidx.annotation.NonNull;
import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import org.jetbrains.annotations.NotNull;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory<T extends ViewModel> extends ViewModelProvider.NewInstanceFactory {

    private final Class<T> viewModelClass;
    private final Supplier<T> viewModelSupplier;
    public ViewModelProviderFactory(Class<T> viewModelClass, Supplier<T> viewModelSupplier){
        this.viewModelClass = viewModelClass;
        this.viewModelSupplier = viewModelSupplier;
    }

    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModelClass)){
            return (T) viewModelSupplier.get();
        }else{
            throw new IllegalArgumentException("Unknown class name"+viewModelClass.getName());
        }
    }
}
