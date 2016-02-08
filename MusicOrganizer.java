import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer(String carpetaMusica)
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary(carpetaMusica);
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }
    
    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
    
    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.incrementPlayCount();
        }
    }
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }
    
    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }
    
    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }
    
    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(tracks.size() > 0) {
            player.startPlaying(tracks.get(0).getFilename());
        }
    }
    
    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }
    
    /**
     * Metodo que permite recibir un parametro que busca el titulo
     * de un track e imprime por pantalla sus detalles
     */
    public void findInTitle(String titlename) {
        for (Track track : tracks) {
            if(track.getTitle().contains(titlename)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Metodo que permite fijar el valor del album en el organizador
     */
    public void setAlbum(int index, String albumName) {
        if(indexValid(index)) {
            Track track = tracks.get(index);
            albumName = track.getAlbum();
        }
    }
    
    /**
     * Metodo que muestra los detalles de la coleccion de tracks con un iterator
     */
    public void listAllTrackWithIterator () {
        Iterator <Track> it = tracks.iterator();
        while (it.hasNext()) {
            Track tracks = it.next();
            System.out.println(tracks.getDetails());
        }
    }
    
    /**
     * Metodo que permite eliminar un track que tenga como parametro el artista pasado
     * con un iterator
     */
    public void removeByArtist(String nombreArtista) {
        Iterator <Track> it = tracks.iterator();
        while (it.hasNext()) {
            Track tracks = it.next();
            if (tracks.getArtist().contains(nombreArtista)) {
                it.remove();
            }
        }
    }
    
    /**
     * Metodo que permite eliminar un track que tenga como parametro el titulo pasado
     * con un iterator
     */
    public void removeByTitle(String nombreTitulo) {
        Iterator <Track> it = tracks.iterator();
        while (it.hasNext()) {
            Track tracks = it.next();
            if (tracks.getTitle().contains(nombreTitulo)) {
                it.remove();
            }
        }
    }
    
    /**
     * Metodo que permite reproducir canciones al azar
     */
    public void playRandom () {
        Random  rnd = new Random();
        int index = (rnd.nextInt(tracks.size()));
        if(indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        }
    }
    
    /**
     * Metodo que permite reproducir los primeros segundos de una cancion en modo alatorio
     */
    public void playShuffle () {
        Random  rnd = new Random();
        int index = (rnd.nextInt(tracks.size()));
        if(indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.incrementPlayCount();
        }
    }
}
