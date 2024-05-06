public class Anonym05 {
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "THe button is working!", Toast.LENGTH_SHORT).show();
        }
    });
}

or

btn.setOnClickListener(view -> Toast.makeText(MainActivity.this, "The button is working!", Toast.LENGTH_SHORT).show());
