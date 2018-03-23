package tai.springmvcrecipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void SetUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        category.setId(4l);

        assertEquals(Long.valueOf(4L), category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}