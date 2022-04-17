package com.example.a109590031_hw7_2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class RecipePage extends Activity {

    public static int index = 0;

    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    String[] descriptions = {
            "芝麻清油、綠竹筍、肉絲、蒜頭、辣椒醬\n" +
                    "1. 綠竹筍切條狀。\n" +
                    "\n" +
                    "2. 熱鍋加入芝麻清油，翻炒肉絲到上色。\n" +
                    "\n" +
                    "3. 加入竹筍翻炒，倒些水，悶煮一下。\n" +
                    "\n" +
                    "4. 加些辣椒醬。 (可依個人需求，也可不加改用醬油、鹽等)\n" +
                    "\n" +
                    "5. 加入備用的肉絲炒個兩下，完成。",
            "肉蟹 1 只（大约 300g） * 份数\n" +
                    "咖喱块 15g（一小块）*份数\n" +
                    "椰浆 100ml*份数\n" +
                    "鸡蛋 1 个 *份数\n" +
                    "洋葱 200g *份数\n" +
                    "大蒜 5 瓣 *份数\n\n" +
                    "肉蟹掀盖后对半砍开，蟹钳用刀背轻轻拍裂，切口和蟹钳蘸一下生粉，不要太多。撒 5g 生粉到蟹盖中，盖住蟹黄，备用\n" +
                    "洋葱切成洋葱碎，备用\n" +
                    "大蒜切碎，备用\n" +
                    "烧一壶开水，备用\n" +
                    "起锅烧油，倒入约 20ml 食用油，等待 10 秒让油温升高\n" +
                    "将螃蟹切口朝下，轻轻放入锅中，煎 20 秒，这一步主要是封住蟹黄，蟹肉。然后翻面，每面煎 10 秒。煎完将螃蟹取出备用\n" +
                    "将螃蟹盖放入锅中，使用勺子舀起锅中热油泼到蟹盖中，煎封住蟹盖中的蟹黄，煎 20 秒后取出备用\n" +
                    "不用刷锅，再倒入 10ml 食用油，大火让油温升高至轻微冒烟，将大蒜末，洋葱碎倒入，炒 10 秒钟\n" +
                    "将咖喱块放入锅中炒化（10 秒），放入煎好的螃蟹，翻炒均匀\n" +
                    "倒入开水 300ml，焖煮 3 分钟。\n" +
                    "焖煮完后，倒入椰浆和蛋清，关火，关火后不断翻炒，一直到酱汁变浓稠。\n" +
                    "出锅"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);
        ImageView image = findViewById(R.id.imageView2);
        image.setImageResource(images[index]);
        TextView textView = findViewById(R.id.textView4);
        textView.setText(descriptions[index]);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
