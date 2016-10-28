package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Faculty
{
  private java.util.Date created;
  private String objectId;
  private String faculty;
  private java.util.Date updated;
  private String ownerId;
  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getFaculty()
  {
    return faculty;
  }

  public void setFaculty( String faculty )
  {
    this.faculty = faculty;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public Faculty save()
  {
    return Backendless.Data.of( Faculty.class ).save( this );
  }

  public Future<Faculty> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Faculty> future = new Future<Faculty>();
      Backendless.Data.of( Faculty.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Faculty> callback )
  {
    Backendless.Data.of( Faculty.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Faculty.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Faculty.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Faculty.class ).remove( this, callback );
  }

  public static Faculty findById( String id )
  {
    return Backendless.Data.of( Faculty.class ).findById( id );
  }

  public static Future<Faculty> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Faculty> future = new Future<Faculty>();
      Backendless.Data.of( Faculty.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Faculty> callback )
  {
    Backendless.Data.of( Faculty.class ).findById( id, callback );
  }

  public static Faculty findFirst()
  {
    return Backendless.Data.of( Faculty.class ).findFirst();
  }

  public static Future<Faculty> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Faculty> future = new Future<Faculty>();
      Backendless.Data.of( Faculty.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Faculty> callback )
  {
    Backendless.Data.of( Faculty.class ).findFirst( callback );
  }

  public static Faculty findLast()
  {
    return Backendless.Data.of( Faculty.class ).findLast();
  }

  public static Future<Faculty> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Faculty> future = new Future<Faculty>();
      Backendless.Data.of( Faculty.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Faculty> callback )
  {
    Backendless.Data.of( Faculty.class ).findLast( callback );
  }

  public static BackendlessCollection<Faculty> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Faculty.class ).find( query );
  }

  public static Future<BackendlessCollection<Faculty>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Faculty>> future = new Future<BackendlessCollection<Faculty>>();
      Backendless.Data.of( Faculty.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Faculty>> callback )
  {
    Backendless.Data.of( Faculty.class ).find( query, callback );
  }
}