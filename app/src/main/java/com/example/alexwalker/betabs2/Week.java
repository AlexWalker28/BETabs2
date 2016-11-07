package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Week
{
  private Integer dayOfTheWeek;
  private String ownerId;
  private String objectId;
  private java.util.Date created;
  private java.util.Date updated;
  public Integer getDayOfTheWeek()
  {
    return dayOfTheWeek;
  }

  public void setDayOfTheWeek( Integer dayOfTheWeek )
  {
    this.dayOfTheWeek = dayOfTheWeek;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public Week save()
  {
    return Backendless.Data.of( Week.class ).save( this );
  }

  public Future<Week> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Week> future = new Future<Week>();
      Backendless.Data.of( Week.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Week> callback )
  {
    Backendless.Data.of( Week.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Week.class ).remove( this );
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
      Backendless.Data.of( Week.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Week.class ).remove( this, callback );
  }

  public static Week findById( String id )
  {
    return Backendless.Data.of( Week.class ).findById( id );
  }

  public static Future<Week> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Week> future = new Future<Week>();
      Backendless.Data.of( Week.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Week> callback )
  {
    Backendless.Data.of( Week.class ).findById( id, callback );
  }

  public static Week findFirst()
  {
    return Backendless.Data.of( Week.class ).findFirst();
  }

  public static Future<Week> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Week> future = new Future<Week>();
      Backendless.Data.of( Week.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Week> callback )
  {
    Backendless.Data.of( Week.class ).findFirst( callback );
  }

  public static Week findLast()
  {
    return Backendless.Data.of( Week.class ).findLast();
  }

  public static Future<Week> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Week> future = new Future<Week>();
      Backendless.Data.of( Week.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Week> callback )
  {
    Backendless.Data.of( Week.class ).findLast( callback );
  }

  public static BackendlessCollection<Week> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Week.class ).find( query );
  }

  public static Future<BackendlessCollection<Week>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Week>> future = new Future<BackendlessCollection<Week>>();
      Backendless.Data.of( Week.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Week>> callback )
  {
    Backendless.Data.of( Week.class ).find( query, callback );
  }
}