package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class LessonNumber
{
  private String number;
  private java.util.Date updated;
  private java.util.Date created;
  private String time;
  private String objectId;
  private String ownerId;
  public String getNumber()
  {
    return number;
  }

  public void setNumber( String number )
  {
    this.number = number;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime( String time )
  {
    this.time = time;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public LessonNumber save()
  {
    return Backendless.Data.of( LessonNumber.class ).save( this );
  }

  public Future<LessonNumber> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonNumber> future = new Future<LessonNumber>();
      Backendless.Data.of( LessonNumber.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<LessonNumber> callback )
  {
    Backendless.Data.of( LessonNumber.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( LessonNumber.class ).remove( this );
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
      Backendless.Data.of( LessonNumber.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( LessonNumber.class ).remove( this, callback );
  }

  public static LessonNumber findById( String id )
  {
    return Backendless.Data.of( LessonNumber.class ).findById( id );
  }

  public static Future<LessonNumber> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonNumber> future = new Future<LessonNumber>();
      Backendless.Data.of( LessonNumber.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<LessonNumber> callback )
  {
    Backendless.Data.of( LessonNumber.class ).findById( id, callback );
  }

  public static LessonNumber findFirst()
  {
    return Backendless.Data.of( LessonNumber.class ).findFirst();
  }

  public static Future<LessonNumber> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonNumber> future = new Future<LessonNumber>();
      Backendless.Data.of( LessonNumber.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<LessonNumber> callback )
  {
    Backendless.Data.of( LessonNumber.class ).findFirst( callback );
  }

  public static LessonNumber findLast()
  {
    return Backendless.Data.of( LessonNumber.class ).findLast();
  }

  public static Future<LessonNumber> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonNumber> future = new Future<LessonNumber>();
      Backendless.Data.of( LessonNumber.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<LessonNumber> callback )
  {
    Backendless.Data.of( LessonNumber.class ).findLast( callback );
  }

  public static BackendlessCollection<LessonNumber> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( LessonNumber.class ).find( query );
  }

  public static Future<BackendlessCollection<LessonNumber>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<LessonNumber>> future = new Future<BackendlessCollection<LessonNumber>>();
      Backendless.Data.of( LessonNumber.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<LessonNumber>> callback )
  {
    Backendless.Data.of( LessonNumber.class ).find( query, callback );
  }
}