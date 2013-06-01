package com.example.cs110;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_ORIGIN = "origin";  
    public static final String KEY_DESCRIPTION = "description";
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "wine";
    private static final String DATABASE_TABLE = "wines";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table wines (_id integer primary key autoincrement, "
        + "name text not null, type text not null, " 
        + "origin text not null, description text not null);";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS wines");
            onCreate(db);
        }
    }    
    
    //opens the database
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //closes the database
    public void close() 
    {
        DBHelper.close();
    }
    
    //insert a wine into the database
    public long insertWine(String name, String type, String origin, String description) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_TYPE, type);
        initialValues.put(KEY_ORIGIN, origin);
        initialValues.put(KEY_DESCRIPTION, description);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //deletes a particular wine
    public boolean deleteWine(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
        		"=" + rowId, null) > 0;
    }
    
    //deletes entire database
    public int deleteAllWines()
    {
    	return db.delete(DATABASE_TABLE, null, null);
    }

    //retrieves all the wines
    public Cursor getAllWines() 
    {
        return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_NAME,
        		KEY_TYPE,
                KEY_ORIGIN,
                KEY_DESCRIPTION}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }

    //retrieves a particular wine
    public Cursor getWine(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_NAME, 
                		KEY_TYPE,
                		KEY_ORIGIN,
                		KEY_DESCRIPTION
                		}, 
                		KEY_ROWID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //updates a wine
    public boolean updateWine(long rowId, String name, 
    String type, String origin, String desc) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_TYPE, type);
        args.put(KEY_ORIGIN, origin);
        args.put(KEY_DESCRIPTION, desc);
        return db.update(DATABASE_TABLE, args, 
                         KEY_ROWID + "=" + rowId, null) > 0;
    }
    
    //populate database
    public void populateDatabase(){
    	ContentValues initialValues = new ContentValues();
    	
    	// RED
    	// =====================================
    	
        initialValues.put(KEY_NAME, "Armailhac");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Lovely expression of spicy, slightly exotic black fruits, beautiful lift of freshness and briary charm - a lovely wine for the medium term.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Batailley");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Robust, rather earthy fruit, then a touch of violets to lift it and a hint of leather, good wine, good future.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Bon Pasteur");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "The ripe tannins in this wine give a beautiful impression and the ripe yet reserved fruit match nicely. Full and very integrated. Elegant and sexy.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Branaire Ducru");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "A very pretty red with flowers, blackberries, and blueberries. Full and silky with racy tannins and a long finish. Some hints of cocoa and pleasant bitterness. Well structured.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Canon");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "A wine with balance and freshness with an orange peel and blueberry character. Medium to full body, with firm tannins and clean, bright finish. Merlot 70% and 30% Cabernet Franc.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Canon la Gaffeliere");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "There is a nice mix of flavours on the nose with the sweetness of the black fruits balanced by fresher red. The mid palate seems quite light with raspberries and wild strawberries but the black fruits are there behind their richness filling out the finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cantemerle");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Bilberry and bramble give freshness on the nose and palate. There are richer flavours in the middle quite sweet cassis backed by firmer black cherry. The underlying tannins are firm tending to hold back the fruit and shorten the finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Capbern Gasqueton");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Some pleasant fruit with a earthy, spicy finish. A little light. 74% Cabernet Sauvignon and 26% Merlot.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Carruades de Lafite");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "A wine with sweet tobacco and coffee character. Full body, with velvety tannins and a medium finish. The Petit Verdot comes out here with spices and hints of fresh herbs. Blend of 55% Cabernet Sauvignon, 39% Merlot 3.5% Cabernet Franc, and 2.5% Petit Verdot.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Chapelle d'Ausone");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "The nose is black fruited quite light but with attractive fragrances. The fruit on the mid palate feels ripe the rounded tannins giving suppleness and towards the back the layers of flavour give some complexity.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "La Chapelle de la Mission");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Floral summer fruits, clarity and purity. Quite vigourous, it needs time to soften.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Leoville Poyferre");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "The nose is rich deep black fruited profound. It feels fresher on the start of the palate with hints of red fruits that lighten and bring out a touch of spice. The back palate is sweet fruited well supported by the tannic structure.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Clos Fourtet");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "A beautiful wine, with everything in the bottle. Blackberries, minerals and blueberries. Full and silky. Long, long finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Charmes Chambertin");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Burgundy");
        initialValues.put(KEY_DESCRIPTION, "Dark red berries, flowers, mint and spices are woven together beautifully in this lush, generous Charmes.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Gevrey Chambertin");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Burgundy");
        initialValues.put(KEY_DESCRIPTION, "The detailed, delicious and vibrant middle weight flavors possess good depth and solid persistence.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Gevrey Lavaux St Jacques");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Burgundy");
        initialValues.put(KEY_DESCRIPTION, "there is excellent vibrancy and punch to the intensely mineral-inflected medium weight flavors that possess fine delineation and a lovely sense of underlying tension on the complex, persistent and palate staining finish. This is really quite impressive and worth considering.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Vosne Petit Monts");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Burgundy");
        initialValues.put(KEY_DESCRIPTION, "A more restrained and slightly less lavishly spiced nose features ripe dark berry fruit and earth aromas that merge gracefully into the focused, concentrated and firm middle weight flavors that are supported by tannins that are less fine but there is notably more complexity and slightly better length as well. ");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cornas");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "Cornas exhibits classic notes of blackberries, cassis, camphor, incense, violets and hints of forest floor as well as steak tartare, a sensational texture, a full-bodied opulence, and terrific richness. This remarkable Cornas can be drunk early or cellared for 15-20 years.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Mon Coeur");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "This dense ruby/purple-colored, rich wine reveals kirsch and black currant fruit intermixed with notions of spice box, pepper and meat. Luscious and round.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cuvee Quet");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, " Its dense purple color is accompanied by an exquisite bouquet of boysenberries, mulberries, blueberries and other wild mountain blue and black fruits. Possessing great intensity, a full-bodied mouthfeel and superb purity, it is a singular expression of old vine Grenache blended with Mourvedre.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cote Rotie");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "Opaque purple. Explosively perfumed scents of red and dark berries, potpourri and Asian spices, with black pepper and mineral nuances gaining strength with air. Juicy and expansive on the palate, showing intense black raspberry and blueberry flavors and an exotic touch of candied violet.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Hermitage Rouge");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "Hermitage exhibits a black/purple color along with a sumptuous nose of roasted meats, ground pepper, black currants, blackberry jam, and subtle smoke and licorice. The extraordinary bouquet is followed by a wine of extravagant intensity as well as tremendous focus and precision.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Chateauneuf-du-Pape");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "A blend of 85% Grenache and the rest equal parts Mourvedre, Vaccarese, and Syrah, all aged in old tanks, it exhibits a deep ruby/purple color as well as a sumptuous bouquet of black raspberries, kirsch liqueur, and subtle notions of underbrush and nori seaweed wrapper. Rayas-like in its ethereal richness, length, and texture with a sense of lightness despite its weight, this beauty possesses superb purity, equilibrium, texture, and elegance.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Les Origines");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "Grenache Noir 50%, Syrah 20%, Mourvedre 30%. Aged in barrique and cuve. Pretty, floral elements on the nose. Rather restrained and feminine. A little low key with tannins just very slightly austere.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cote Rotie Landonne");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Rhone");
        initialValues.put(KEY_DESCRIPTION, "It exhibits notes of asphalt, blackberries, charcoal, truffles, roasted meats and creme de cassis. Full-bodied as well as extraordinarily pure and rich, it is approachable.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Pinot Noir");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "New Zealand");
        initialValues.put(KEY_DESCRIPTION, "A rich and juicy wine with plum and dried strawberry character. Aromatic with beet root.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Syrah Gimblett Gravels");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "New Zealand");
        initialValues.put(KEY_DESCRIPTION, "Gimblett Gravels Syrah has aromas of warm blackberries, black cherries and cassis with hints of black pepper, licorice and tar. Medium bodied, the black berry laced palate is just a little lean in the middle with a medium level of chewy tannins and crisp acidity, finishing with medium to long persistence.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cabernet Merlot Helmsman");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "New Zealand");
        initialValues.put(KEY_DESCRIPTION, "Displays a deep garnet-purple color and plumy, blueberry and Indian spice notes on the nose with a whiff of damp loam.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Nebbiolo Valmaggiore");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Firm yet well-integrated tannins frame red cherries, sweet herbs, menthol and spices in this surprisingly large-scaled, broad Valmaggiore. Layers of fruit continue to build to the vibrant, layered finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Ornellaia");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "This wine is exceptionally beautiful and polished from the very first taste. Ripe, red berries, crushed flowers and deeply spiced notes are woven into an intricate fabric of indescribable class.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Rosso di Montalcino");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Has a medium ruby-purple color and expressive notes of black cherries, black raspberries and mulberries over allspice, cinnamon stick and milk chocolate. Full bodied with a medium level of finely grained tannins, it has a generous amount of berry and spice flavors in the mouth nicely offset by crisp acid.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Sassicaia");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "What incredible aromas here with blueberries, spices, licorice, plums. Graphite too. Subtle and complex. Full and silky with a beautiful texture of fine tannins and an ultra-fine finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Scrio");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Currant bush and blueberry aromas follow through to a full to medium body, with medium tannins and a chocolate, berry and vanilla bean after taste.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Tenuta Di Trinoro");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Presents exotic notes of wild cherries, plums, spices, minerals and licorice all of which come together on a silky, polished frame. Smoke, incense and a host of other seductive, beguiling aromas and flavors add complexity as they wrap around the seriously intense finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Barolo Pajana");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "The wine shows good plushness and generosity in its dark red fruit, mocha, spices, new leather, flowers and licorice, all of which flesh out on the supple finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Barbaresco");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Sweet, perfumed and totally gorgeous in its round, sensual fruit. Silky, elegant tannins frame the long, harmonious finish. ");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Brunello di Montalcino");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "An exotic melange of freshly cut flowers, dark cherries and plums conquers all of the senses. Intense saline notes and the wine's underlying minerality are buried under the massive fruit, but over time they emerge.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Masseto");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Masseto is fabulous. Loads of black cherry, blackberry and cassis are intermingled with minerals, violets and French oak. This is an especially sensual Masseto that impresses for its clarity, intensity and length.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Solaia");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Italy");
        initialValues.put(KEY_DESCRIPTION, "Solaia saturates the palate with a heady array of super-ripe black cherries, plums, cassis, mocha and sweet French oak.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Kalimna Shiraz");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "Presents lovely, expressive blueberry, black raspberry and black cherries notes highlighted by violets, toast, cinnamon stick and touch of mulberries. Full-bodied and rich, the concentrated fruit is framed by medium levels of rounded tannins, crisp acid and a long, classically-styled finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cabernet Shiraz");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "Displays pure cassis and black cherry cordial aromas underlying notes of aniseed, violets, pepper and chocolate. Medium to full-bodied, the palate is voluptuous and wonderfully balanced between vibrant acid and a medium level of fine tannins.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Shiraz");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "Shiraz is a little closed showing intense and youthful primary aromas of cassis, kirsch, cedar, prunes and a touch of mulberries. Rich, muscular, packed with flavor, it is full-bodied, concentrated and finishes long with oak still poking out.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Grange");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "Grange puts forward a very complex nose packed with aromas of mulberries, layers of baking spices, cloves and cinnamon with nuances of minced meat, anise, potpourri and whiffs of dried mint and chocolate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "The Laird");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "The Laird is a little restrained to begin, opening out after a few moments and much coaxing to an extraordinary array of creme de cassis and black plum-based aromas with underlying chocolate box, licorice, exotic spice, oolong tea and clove hints with a touch of earthy loam.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "La Pleiade");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "It offers up a soaring, complex bouquet of Asian spices, incense, smoked meat, game, and blueberry. This leads to a full-bodied, voluptuous, dense, structured wine with layers of succulent fruit");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Run Rig");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "Saturated opaque purple/black, it has a remarkably kinky, exotic perfume of fresh asphalt, pencil lead, smoke, pepper, game, blueberry and black raspberry.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Shiraz Cabernet");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Australia");
        initialValues.put(KEY_DESCRIPTION, "An inky/purple color is accompanied by a sumptuous bouquet of apricots, honeysuckle, black raspberries, blackberries, licorice, and a hint of roasted meats.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Churchill");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "This is very floral and fruity with dark cherries and wild berries. Full body, lightly sweet with lots of fruit and a firm tannic backbone.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cockburn");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Great nose here with flowers, leaves and a wet earth character. Full body, lightly sweet with a massive finish. This is muscular, toned and intense.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Croft");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Beautiful aromas of violets and blueberries with hints of blue slate. Full body, medium sweet with chewy tannins and a long, long finish. A leafy, stemmy, nutty undertone to this with hints of shaved milk chocolate. Very refined and beautiful.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Dow");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "The nose is firm quite austere with a mix of cassis and red cherry. The start of the palate feels fresh with more red fruits than black the fruit underpinned by fresh green figs.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Fonseca");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Very grapy and leafy with hints of spices on the nose. Full body, medium sweet with fine, chewy tannins. Powerful, long finish with nuts and shaved chocolate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Graham");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "A very complex and profound nose with hints of dark chocolate. Intense ripe red fruits on the palate. Firm but not aggressive tannins. Enormous body but with some fine acidity and minerality on the finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Niepoort");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Great nose here of crushed raspberries and minerals with hints of dark chocolate. Full body, medium sweet with a chewy, peppery and lightly stemmy character. It's long and tannic but very polished.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Quinta do Noval");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Fresh red fruits give a lovely brightness on the nose and although the start of the palate has the same freshness of flavour the mid palate is rich with ripe fruit lush and fleshy. There is a good mix of flavours red fruits and black fruits lots of complexity and the finish has power and depth yet fragrance.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Quinta do Vesuvio");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Aromas of flowers and berries with hints of dried fruits. Full body, medium sweet with solid tannins and a powerful palate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Smith Woodhouse");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "There is an attractive smoky quality about the nose very black fruit in character with a touch of spice, hints of cedar wood and pine needles. The rich bramble fruit is backed by liquorice and bitter chocolate a lovely complex mix and although the tannins have grip they have a seamless quality with the black fruited mix lingering on the finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Taylor");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "A dense blue-black colour. Immediately open on the nose with the exotic perfume of violets and cassis; creamy, sweet and opulent. A waft of smoky garrigue and roasted coffee bean complement the plump ripe red berry fruits.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Warre");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Vintage Port");
        initialValues.put(KEY_DESCRIPTION, "Extremely floral and fruity with hints of lilacs and crushed fruit. Full body with refined tannins integrated with a solid core of fruit, and a rich, round texture. This is lightly sweet and follows through to a long, long finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Aalto");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "Focus on the nose with vanilla-tinged dark cherry and cassis fruit, followed by an undertow of candied orange peel. The palate is already displaying wonderful balance, with supple, very fine tannins and a luscious, sweet candied finish that offers blood orange and tangerine-infused dark fruit.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Contador");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "Beautifully balanced, with layers of ripe blackberry, creme de cassis and blueberry jam. The texture is satin-like with a generous finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        
        initialValues.put(KEY_NAME, "Vina de Andres Romeo");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "Raisiny, spicy, mellow. Lovely. Vigorous. ");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Clos Mogador");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "Asian spices, tapenade, incense, licorice, espresso, and blackberry aromas inform the nose of this structured, dense plush, powerful yet elegant offering.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Numanthia");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "It has a rounded, generous bouquet of raspberry coulis, wild strawberry and vanilla pod that is well-defined and not over-powering. The palate is medium-bodied with a spicy, elegant entry.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Pintia");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "A clear dark brown colour that looks like a mature Tokaji, with thick tears in the glass. It has a very intense, almost honeyed bouquet with allspice, singed leather, pressed rose petals, molasses, mint and a touch of dried fig.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "San Roman");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "It offers a very seductive bouquet with luscious red berry fruit - raspberry, wild strawberry infused with crushed violets that open with aeration. The palate is full-bodied and very well-balanced, ripe succulent tannins, plush blueberry and black cherries forming the core followed by a silky, ripe, sensual, velvety smooth finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "El Pison");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, "It gives up an outstanding perfume of pain grille, pencil lead, damp earth, incense, and black cherry. Opulent on the palate, it is dense, rich, and full-flavored with enough ripe tannin.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cirsion");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Spain");
        initialValues.put(KEY_DESCRIPTION, " A deep ruby/purple color precedes a smoky, barbecue spice-scented nose revealing aromas of licorice, black as well as red fruits, earth, and charcoal.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Coteaux de Languedoc Prestige Rouge");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Southern France");
        initialValues.put(KEY_DESCRIPTION, "Deep, dark and broody, there is plenty going on in the glass but mainly notes of dark cherries, chocolates and spices.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Domaine de Trevallon Rouge");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Southern France");
        initialValues.put(KEY_DESCRIPTION, "A gorgeous, minty bouquet with blackberry, a touch of blueberry, crushed violets and a little strawberry jam. It blossoms with aeration in the glass. The palate is smooth and rounded on the entry: caressing and voluminous in the mouth. The fruit is very pure with notes of strawberry.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Coteaux du Languedoc Tete de Belier");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Southern France");
        initialValues.put(KEY_DESCRIPTION, "A striking amalgam of arbor vitae and rosemary with nutmeg and cocoa powder overs above a rich reservoir of sweetly ripe black raspberry, dark cherry, and purple plum. The counterpoint of spice and sweet fruit with herbal pungency persists across this wine's polished, finely-tannic palate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Fleur du Perigord Rouge");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Southern France");
        initialValues.put(KEY_DESCRIPTION, "There is a lovely mix of hedgerow fruits on the nose bramble, blackcurrant and raspberry. The start of the palate is fresh but it fills out in the middle lush ripe fruited with chocolate and coffee lots of complex flavours. The finish is long rich fruited with a hint of ginger.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Argentino Malbec");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Argentina");
        initialValues.put(KEY_DESCRIPTION, "It has a more opulent bouquet than the individual blends, with dark cherries, iodine, minerals and blueberry that are all beautifully defined. The palate has a dense, weighty entry with layers of ripe blackberry and boysenberry fruit laced with crushed stone and a touch of graphite.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cabernet Sauvignon");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Argentina");
        initialValues.put(KEY_DESCRIPTION, "It has a spellbinding bouquet that exudes minerality, as if crushed stones had been sprinkled into the black fruit. With continued aeration, there are scents of oyster shell and black olive. The palate is full-bodied, with immense structure and backbone.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Malbec Catena Alta");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Argentina");
        initialValues.put(KEY_DESCRIPTION, "A bit compact, but lively, elegant and flavorful.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cheval des Andes");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Argentina");
        initialValues.put(KEY_DESCRIPTION, "This leads to an enthralling nose of sandalwood, floral notes, exotic spices, a velvety texture, complex flavors, and an overall suave personality.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cabernet Sauvignon");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "Emerges from the glass with tobacco, grilled herbs, smoke, incense and plums melding together in this soft, beautifully textured wine.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Dominus");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "It has a complex bouquet of blackberry, crushed stone, smoke and lavender that is beautifully defined and sophisticated. The palate is medium-bodied with grainy tannins.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Pinot Noir");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "It exhibits sweet pomegranate, raspberry, cherry, roasted herb notes along with a hint of smoky oak in its seductive, round, opulent personality.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "La Muse");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "Notions of mocha, sweet espresso roast, plum, anise, and black cherries jump from the glass. Abundant spice, subtle notes of French oak, and a full-bodied, fleshy personality.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "La Joie");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "Exhibits a sweet, opulent bouquet of charcoal, burning embers, forest floor, blackberries and kirsch. Deep, full-bodied, supple-textured, flamboyant and extroverted with undeniable purity as well as finesse.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Harlan Estate");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "A blend of 80% Cabernet Sauvignon, with the rest Merlot and Cabernet Franc, this enormously-endowed, profoundly rich wine must be tasted to be believed. Opaque purple-colored, it boasts spectacular, soaring aromatics of vanilla, minerals, coffee, blackberries, licorice, and cassis.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Zinfandel");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "Boasts a sweet nose of chocolate-covered blueberries, blackberries, melted licorice, smoked herbs, and earth. This opulent, full-bodied, luscious wine conceals plenty of tannin behind its voluptuous personality.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Almaviva");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "Chile");
        initialValues.put(KEY_DESCRIPTION, "A  formidable wine of exceptional richness, layers of flavor, and a multi-dimensional personality. The color is a deep saturated ruby/purple. The nose offers up juicy/jammy strawberry, black currant, and blackberry notes wrapped with subtle toasty oak.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Vinedo Chadwick");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "California");
        initialValues.put(KEY_DESCRIPTION, "It has a lovely, Margaux inspired floral bouquet with superb delineation and vigor. The palate is rounded and generous with fine tannins and excellent delineation towards the finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Anwilka");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "South Africa");
        initialValues.put(KEY_DESCRIPTION, "The nose is still very backward and giving little away at the moment, but the palate displays admirable concentration and depth with lush, rounded plumy black fruits and a firm structure.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Lourens River Valley Red");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "South Africa");
        initialValues.put(KEY_DESCRIPTION, "A blend of 25% Merlot, 53% Cabernet Franc, 21% Cabernet Sauvignon and 1% Petit Verdot. It has a more refined, herbaceous bouquet compared to other vintages whilst the palate is well structured but is a little green around the edges.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Morgenster");
        initialValues.put(KEY_TYPE, "Red");
        initialValues.put(KEY_ORIGIN, "South Africa");
        initialValues.put(KEY_DESCRIPTION, "A blend of 36% Merlot, 33% Cabernet Franc, 19% Cabernet Sauvignon and 21% Petit Verdot. It has lifted blackberry, mulberry and mint on the nose with just a touch of sage and dried herbs. The palate is medium-bodied with dry tannins on the entry, a fleshy core of red cherry and wild strawberry.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        // RED
        // ======================
        // WHITE
        
        initialValues.put(KEY_NAME, "La Clarte de Haut Brion");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Yellow fruits and dry herbs nose, supple and fleshy texture, precise and lifted acidity.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Cos d'Estournel Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "This is a very sexy wine that is full of grapefruit and pineapple flavours with a touch of cream. Rich but fresh with bright acidity.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Domaine de Chevalier Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Pale lemon gold, dry herbs and dry honey over vibrant purity of fruit, great precision and length.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "de Fieuzal Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Oodles of cream here with citric and pineapple freshness to balance. Ripe yet zesty.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Lynch Bages Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Very lively white with wonderful pineapple, honey and lemons on the nose and palate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Pape Clement Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "A white with fabulous depth and structure that shows layers of sliced apple, mineral, chalk, and mango character. It's layered and powerful like a top red. The line of acidity is wonderful.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Aile d'Argent");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "This blend of 47% Semillon and the rest Sauvignon Blanc and Sauvignon Gris offers up lush pineapple and heady melon notes with plenty of good acidity and subtle smokiness. It's a beauty.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Malartic Lagraviere Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "This full-bodied blend of 85% Sauvignon Blanc and 15% Semillon hit 14.5% natural alcohol. It is deep and rich, with loads of caramelized grapefruit, tropical fruit, subtle oak, wet stones and plenty of melons.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Monbousquet Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "At 67% Sauvignon Blanc, 33% Semillon it is very crisp, fresh and lively.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Ygrec");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Bordeaux");
        initialValues.put(KEY_DESCRIPTION, "Wonderfully complex nose in this white with ripe lemon, green papaya, lime peel and lots of ripe yellow peach. Full and focused, it offers a beautiful ripe acidity and silky texture on the palate.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Chevalier Montrachet la Cabotte");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Precise aromas of lime and crushed stone. More reserved and opulent than the Chevalier today but purer and higher-pitched, boasting outstanding precision to its citrus and floral flavors. Really superb energy here.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Chevalier Montrachet Demoiselles");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Bright pale yellow. Rich aromas and flavors of lemon zest, white flowers and gingerbread. Full and sappy but given an urgent, juicy quality by a superb acid/mineral spine.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Corton Charlemagne");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Bright yellow. Sexy, exotic high-toned aromas of candied peach, marmalade and pineapple liqueur; smells a bit like a riesling vendange tardive.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Macon Pierreclos Chavigne Blanc");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Good pale yellow. Pure, scented nose offers aromas of lime, pineapple, acacia flower and powdered stone. Sappy, spicy and dense with extract, boasting lovely definition and a pronounced mineral character.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Meursault Les Clous");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "The energetic and intensely mineral-driven middle weight flavors possess excellent depth on the explosive, balanced and admirably persistent finish.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Meursault Genevrieres");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Good pale yellow. Enticing aromas of peach, pear and white flowers. At once juicy and creamy, with an aromatic hazelnut quality adding interest to the ripe stone fruit flavors. Tactile and expansive wine with a restrained sweetness and excellent saline length.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Montrachet");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Good pale yellow. Deeply pitched aromas of apricot, musky truffle and smoky oak. Fat and sweet following the Cabottes--in fact downright exotic.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Pouilly Fuisse");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Appley and a little tight.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        initialValues.put(KEY_NAME, "Puligny Combettes");
        initialValues.put(KEY_TYPE, "White");
        initialValues.put(KEY_ORIGIN, "Burgandy");
        initialValues.put(KEY_DESCRIPTION, "Pale bright yellow. Ripe aromas of apricot and mirabelle; less minerally and more earthy than the Meursault Perrieres. Fatter and sweeter on the palate too, but shows a slightly herbal edge.");
        db.insert(DATABASE_TABLE, null, initialValues);
        initialValues.clear();
        
        
    }
}