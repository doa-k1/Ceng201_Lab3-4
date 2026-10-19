/**
 * Represents the doubly linked list for the music playlist.
 *
 * Your Name:        Doğa Kasaplı
 * Your Student ID:  240444403
 * Your Date:        19.10.2026
 */

public class MusicPlaylist {

    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // Constructor
    public MusicPlaylist() {
        head = null;
        tail = null;
        current = null;
    }
    // Add a song to the end of the playlist
    public void addSong(String title) {
        SongNode newNode = new SongNode(title);

        // If the playlist is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            // Add the new node after tail
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a song from the playlist
    public void removeSong(String title) {
        SongNode temp = head;

        // Search for the song
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        // Song not found
        if (temp == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        // Update current if the current song is removed
        if (current == temp) {
            if (temp.next != null) {
                current = temp.next;
            } else {
                current = temp.prev;
            }
        }

        // Remove the head
        if (temp == head) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        // Remove the tail
        if (temp == tail) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        // If the list becomes empty
        if (head == null) {
            tail = null;
            current = null;
        }

        // Disconnect the removed node
        temp.prev = null;
        temp.next = null;

        System.out.println("Removed: " + title);
    }
    // Move to the next song
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println(
                    "Already at the last song of the playlist."
            );
        }
    }

    // Move to the previous song
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println(
                    "Already at the first song of the playlist."
            );
        }
    }

    // Display the current song
    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("The playlist is empty.");
        }
    }

    // Display all songs
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }
        SongNode temp = head;

        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
