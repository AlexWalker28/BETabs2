package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class LessonName
{
  private java.util.Date updated;
  private String fullName;
  private java.util.Date created;
  private String objectId;
  private String ownerId;
  private Integer codeName;
  private Department lessonNameDepartment;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getFullName()
  {
    return fullName;
  }

  public void setFullName( String fullName )
  {
    this.fullName = fullName;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getCodeName()
  {
    return codeName;
  }

  public void setCodeName( Integer codeName )
  {
    this.codeName = codeName;
  }

  public Department getLessonNameDepartment()
  {
    return lessonNameDepartment;
  }

  public void setLessonNameDepartment( Department lessonNameDepartment )
  {
    this.lessonNameDepartment = lessonNameDepartment;
  }

                                                    
  public LessonName save()
  {
    return Backendless.Data.of( LessonName.class ).save( this );
  }

  public Future<LessonName> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonName> future = new Future<LessonName>();
      Backendless.Data.of( LessonName.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<LessonName> callback )
  {
    Backendless.Data.of( LessonName.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( LessonName.class ).remove( this );
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
      Backendless.Data.of( LessonName.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( LessonName.class ).remove( this, callback );
  }

  public static LessonName findById( String id )
  {
    return Backendless.Data.of( LessonName.class ).findById( id );
  }

  public static Future<LessonName> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonName> future = new Future<LessonName>();
      Backendless.Data.of( LessonName.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<LessonName> callback )
  {
    Backendless.Data.of( LessonName.class ).findById( id, callback );
  }

  public static LessonName findFirst()
  {
    return Backendless.Data.of( LessonName.class ).findFirst();
  }

  public static Future<LessonName> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonName> future = new Future<LessonName>();
      Backendless.Data.of( LessonName.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<LessonName> callback )
  {
    Backendless.Data.of( LessonName.class ).findFirst( callback );
  }

  public static LessonName findLast()
  {
    return Backendless.Data.of( LessonName.class ).findLast();
  }

  public static Future<LessonName> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonName> future = new Future<LessonName>();
      Backendless.Data.of( LessonName.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<LessonName> callback )
  {
    Backendless.Data.of( LessonName.class ).findLast( callback );
  }

  public static BackendlessCollection<LessonName> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( LessonName.class ).find( query );
  }

  public static Future<BackendlessCollection<LessonName>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<LessonName>> future = new Future<BackendlessCollection<LessonName>>();
      Backendless.Data.of( LessonName.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<LessonName>> callback )
  {
    Backendless.Data.of( LessonName.class ).find( query, callback );
  }
}