package Redactor;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для вкладки Редактирование мобильного приложения Мобильный хоспис")
public class NegativManualTimsTK78Test {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Story("Ручной ввод времени в поле Время, при создании новости, во вкладке Панель управления мобильного приложения (Негативный)")
    public void negativManualTimsTK78Test() {
        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.all_news_text_view), withText("Все новости"),
                        childAtPosition(
                                allOf(withId(R.id.container_list_news_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("Панель \n управления"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("Панель   управления")));

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.add_news_image_view), withContentDescription("Кнопка добавления новости"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                        withParent(withParent(withId(R.id.nav_host_fragment))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction checkableImageButton = onView(
                allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Показать раскрывающееся меню"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        DataInteraction materialTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        materialTextView2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("Объявление"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Объявление2.0"));

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("Объявление2.0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_create_date_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("ОК"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_publish_time_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Чтобы ввести время, перейдите в режим ввода текста."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                3),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("69"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(android.R.id.button1), withText("ОК"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction textView2 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Указано недопустимое время."),
                        withParent(allOf(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))),
                        isDisplayed()));
        textView2.check(matches(withText("Указано недопустимое время.")));

        ViewInteraction materialButton5 = onView(
                allOf(withId(android.R.id.button2), withText("Отмена"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        materialButton5.perform(scrollTo(), click());

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                        withParent(withParent(withId(R.id.nav_host_fragment))),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
