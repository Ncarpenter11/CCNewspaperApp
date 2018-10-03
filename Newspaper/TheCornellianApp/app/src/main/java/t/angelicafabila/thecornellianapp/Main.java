package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main extends AppCompatActivity
{
    Intent intent = new Intent();
    TextView itemTitleBox;
//    TextView itemAuthorBox;
//    TextView itemDateBox;
//    TextView itemContentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add Toolbar
        Toolbar toolbar = findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);

        ImageButton feedRefreshButton = findViewById(R.id.feedRefresh);
        feedRefreshButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new getNews().execute();

            }
        });

        itemTitleBox = findViewById(R.id.itemTitle);
//        itemAuthorBox = findViewById(R.id.itemCreator);
//        itemDateBox = findViewById(R.id.itemPubDate);
//        itemContentBox = findViewById(R.id.itemContent);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();
        configureEmailButton();
    }

    private void configureMainButton()
    {
        Button mainButton = findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Main.class));
            }
        });
    }

    private void configureAboutUsButton()
    {
        Button aboutUsButton = findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, About_Us.class));
            }
        });
    }

    private void configureContactUsButton()
    {
        Button contactUsButton = findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Contact_Us.class));
            }
        });
    }
    private void configureArchiveButton()
    {
        Button archiveButton = findViewById(R.id.ArchiveButton);
        archiveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://cornellcollege.advantage-preservation.com/")));
            }
        });
    }

    private void configureEmailButton()
    {
        Button EmailButton = findViewById(R.id.EmailButton);
        EmailButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity
                        (new Intent(Intent.ACTION_VIEW));
                        Uri data = Uri.parse("mailto: thecornellian@cornellcollege.edu");
                        intent.setData(data);
                        intent.setType("message/rfc822");
                        String [] recipient = {"thecornellian@cornellcollege.edu"};
                        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Letter to the Editor");
                       // String[] to = {"thecornellian@cornellcollege.edu"};
                       // intent.putExtra(Intent.EXTRA_EMAIL, to);
                        //intent.putExtra(Intent.EXTRA_SUBJECT, "Letter to the Editor");
                        //intent.setType("message");
                       // Intent.createChooser(intent, "Send Email");
            }
        });
    }

    public class getNews extends AsyncTask<Void, Void, Void>
    {
        String title;
        String author;
        String date;
        String content;

        @Override
        protected Void doInBackground(Void... voids)
        {
            try
            {
                Document url = Jsoup.connect("https://blogs.cornellcollege.edu/cornellian/").get();

                Element urlTitleText = url.select("h2").first();
                urlTitleText.hasClass("entry-title");

                Element urlAuthorText = url.select("span").first();
                urlAuthorText.hasClass("author vcard");

                Element urlDateText = url.select("span").first();
                urlDateText.hasClass("posted-on");

                Element urlContentText = url.select("span").first();
                urlContentText.hasClass("entry-content");

                title = urlTitleText.text();
                author = urlAuthorText.text();
                date = urlDateText.text();
                content = urlContentText.text();


            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            itemTitleBox.setText(title);
//            itemAuthorBox.setText(author);
//            itemDateBox.setText(date);
//            itemContentBox.setText(content);

        }
    }
}