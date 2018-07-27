package toxm.com.dxt.lxiang1;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import toxm.com.dxt.lxiang1.fragment.HomeFragment;
import toxm.com.dxt.lxiang1.fragment.LikeFragment;
import toxm.com.dxt.lxiang1.fragment.LocationFragment;
import toxm.com.dxt.lxiang1.fragment.MeFragment;
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    HomeFragment homeFragment;
    LikeFragment likeFragment;
    LocationFragment locationFragment;
    MeFragment meFragment;
    RadioGroup radioGroup;
    RadioButton mRadioHome,mRadioLocation,mRadioLike,mRadioMe;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setDefaultFragment();
    }

    private void initView() {
        radioGroup = findViewById(R.id.rg);
        mRadioHome = findViewById(R.id.rb_home);
        mRadioLocation = findViewById(R.id.rb_location);
        mRadioLike = findViewById(R.id.rb_like);
        mRadioMe = findViewById(R.id.rb_me);
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void setDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        if (mRadioHome.isChecked()) {
            setTabState();
            homeFragment = new HomeFragment();
        }
        fragmentManager.beginTransaction().add(R.id.r1_main_content, homeFragment).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hide(transaction);
        switch (checkedId) {
            case R.id.rb_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.r1_main_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case R.id.rb_like:
                if (likeFragment == null) {
                    likeFragment = new LikeFragment();
                    transaction.add(R.id.r1_main_content, likeFragment);
                } else {
                    transaction.show(likeFragment);
                }
                break;
            case R.id.rb_location:
                if (locationFragment == null) {
                    locationFragment = new LocationFragment();
                    transaction.add(R.id.r1_main_content, locationFragment);
                } else {
                    transaction.show(locationFragment);
                }
                break;
            case R.id.rb_me:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.r1_main_content, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                break;
        }
        setTabState();
        transaction.commit();
    }

    private void setTabState() {
        setHomeState();
        setLocationState();
        setLikeState();
        setMeState();
    }

    private void setMeState() {
        if (mRadioMe.isChecked()) {
            mRadioMe.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioMe.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setLikeState() {
        if (mRadioLike.isChecked()) {
            mRadioLike.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioLike.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setLocationState() {
        if (mRadioLocation.isChecked()) {
            mRadioLocation.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioLocation.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setHomeState() {
        if (mRadioHome.isChecked()) {
            mRadioHome.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioHome.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    public void hide(FragmentTransaction ft) {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (likeFragment != null) {
            ft.hide(likeFragment);
        }
        if (locationFragment != null) {
            ft.hide(locationFragment);
        }
        if (meFragment != null) {
            ft.hide(meFragment);
        }
    }
}
