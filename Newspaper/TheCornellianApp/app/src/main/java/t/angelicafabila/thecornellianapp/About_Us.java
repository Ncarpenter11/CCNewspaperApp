package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
        configureArchiveButton();

        /*Editor chief's hyperlink to their bio. */
        TextView editorChiefHyperlink = (TextView) findViewById(R.id.EditorChief);
        editorChiefHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*ANGELS' hyperlink to their bio. */
        TextView assistantEditorChiefHyperlink = (TextView) findViewById(R.id.AssistantEditorChief);
        assistantEditorChiefHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*News editors's hyperlink to their bio. */
        TextView newsEditorHyperlink = (TextView) findViewById(R.id.NewsEditor);
        newsEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*Feature Editors's hyperlink to their bio. */
        TextView featuresEditorHyperlink = (TextView) findViewById(R.id.FeaturesEditor);
        featuresEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*Art and Entertainment Editors's hyperlink to their bio. */
        TextView artEntertainmentEditorHyperlink = (TextView) findViewById(R.id.ArtEntertainmentEditor);
        artEntertainmentEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*Opinion Editor's hyperlink to their bio. */
        TextView opinionEditorHyperlink = (TextView) findViewById(R.id.OpinionEditor);
        opinionEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*Copy editor's hyperlink to their bio. */
        TextView copyEditorHyperlink = (TextView) findViewById(R.id.CopyEditor);
        copyEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
        /*Layout editor's hyperlink to their bio. */
        TextView layoutEditorHyperlink = (TextView) findViewById(R.id.LayoutEditor);
        layoutEditorHyperlink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void configureMainButton()
    {
        Button mainButton = (Button) findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(About_Us.this, Main.class));
            }
        });
    }

    private void configureAboutUsButton()
    {
        Button aboutUsButton = (Button) findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(About_Us.this, About_Us.class));
            }
        });
    }

    private void configureContactUsButton() {
        Button contactUsButton = (Button) findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(About_Us.this, Contact_Us.class));
            }
        });
    }
    private void configureArchiveButton()
    {
        Button archiveButton = (Button) findViewById(R.id.ArchiveButton);
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
}
