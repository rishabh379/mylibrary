package com.example.mylibrary.pvsrishabh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class bookActivity extends AppCompatActivity {

    public  static  final String BOOK_ID_KEY = "bookId";
    private TextView bookName, authorNametxt, pageNo, longDescription;
    private Button btnAddToCurrentlyReading, btnAddToWantToRead, btnAddToALreadyRead, btnAddToFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookName = findViewById(R.id.bookName);
        authorNametxt = findViewById(R.id.authorNametxt);
        pageNo = findViewById(R.id.pageNo);
        longDescription = findViewById(R.id.longDescription);

        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);
        btnAddToALreadyRead = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);

        bookImage = findViewById(R.id.bookImage);

        Intent intent = getIntent();
        if(null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1){
                Book incomingBook = Utils.getInstance(this).getBookId(bookId);
                if(null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToRead(incomingBook);
                    handleCurrentlyReading(incomingBook);
                    handleFavorite(incomingBook);
                }
            }

        }
    }

    private void handleFavorite(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavoriteBooks = false;

        for(Book b: favoriteBooks){
            if(b.getId() == book.getId()){
                existInFavoriteBooks = true;
            }
        }

        if(existInFavoriteBooks){
            btnAddToFavorite.setEnabled(false);
        }
        else{
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(bookActivity.this).addToFavorite(book)){
                        Toast.makeText(bookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(bookActivity.this,favoriteActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(bookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReading(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;

        for(Book b: currentlyReadingBooks){
            if(b.getId() == book.getId()){
                existInCurrentlyReadingBooks = true;
            }
        }

        if(existInCurrentlyReadingBooks){
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(bookActivity.this).addToCurrentlyReading(book)){
                        Toast.makeText(bookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(bookActivity.this,currentlyReadingActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(bookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToRead(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for(Book b: wantToReadBooks){
            if(b.getId() == book.getId()){
                existInWantToReadBooks = true;
            }
        }

        if(existInWantToReadBooks){
            btnAddToWantToRead.setEnabled(false);
        }
        else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(bookActivity.this).addToWantToRead(book)){
                        Toast.makeText(bookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(bookActivity.this,wantToReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(bookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for(Book b: alreadyReadBooks){
            if(b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }

        if(existInAlreadyReadBooks){
            btnAddToALreadyRead.setEnabled(false);
        }
        else{
            btnAddToALreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance(bookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(bookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(bookActivity.this,alreadyReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(bookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        bookName.setText(book.getName());
        setTitle(book.getName());
        authorNametxt.setText(book.getAuthor());
        pageNo.setText(String.valueOf(book.getPages()));
        longDescription.setText(book.getLongDec());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }
}