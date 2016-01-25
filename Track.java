/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    // LLeva la cuenta de las veces que se reproduce una cancion
    private int playCount;
    // Album del Track
    private String album;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename, String album)
    {
        setDetails(artist, title, filename, album);
        playCount = 0;
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename, "unknown");
        playCount = 0;
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
    
    /**
     * Devuelve el contador de canciones reproducidas
     */
    public int getPlayCount()
    {
        return playCount;
    }
    
    /**
     * Devuelve el album del track
     */
    public String getAlbum()
    {
        return album;
    }
    
    /**
     * Metodo que resetea el contador de canciones reproducidas
     */
    public void resetPlayCount() {
        playCount = 0;
    }
    
    /**
     * Metodo que incrementa de uno en uno la cancion reproducida
     */
    public void incrementPlayCount() {
        playCount++;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + album + "  (file: " + filename + ")" + "Veces reproducidas: " + playCount;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename, String album)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.album = album;
    }
    
    public void setAlbum(String album) {
        this.album = album;
    }
}
