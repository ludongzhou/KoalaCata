<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <Program>
                <Title>
                    <ProperTitle>
                        <xsl:value-of select="MetaData.Program.Title.ProperTitle"/>
                    </ProperTitle>
                    <xsl:for-each select="MetaData.Program.Title.ParallelProperTitle">
                        <ParallelProperTitle>
                            <xsl:value-of select="current()"/>
                        </ParallelProperTitle>
                    </xsl:for-each>
                    <SubordinateTitle>
                        <xsl:value-of select="MetaData.Program.Title.SubordinateTitle"/>
                    </SubordinateTitle>
                    <xsl:for-each select="MetaData.Program.Title.AlternativeTitle">
                        <AlternativeTitle>
                            <xsl:value-of select="current()"/>
                        </AlternativeTitle>
                    </xsl:for-each>
                    <TitleDescription>
                        <xsl:value-of select="MetaData.Program.Title.TitleDescription"/>
                    </TitleDescription>
                    <Series>
                        <SeriesTitle>
                            <xsl:value-of select="MetaData.Program.Title.Series.SeriesTitle"/>
                        </SeriesTitle>
                        <xsl:for-each select="MetaData.Program.Title.Series.ParallelSeriesTitle">
                            <ParallelSeriesTitle>
                                <xsl:value-of select="current()"/>
                            </ParallelSeriesTitle>
                        </xsl:for-each>
                        <TotalNumberofEpisodes>
                            <xsl:value-of select="MetaData.Program.Title.Series.TotalNumberofEpisodes"/>
                        </TotalNumberofEpisodes>
                        <EpisodesNumber>
                            <xsl:value-of select="MetaData.Program.Title.Series.EpisodesNumber"/>
                        </EpisodesNumber>
                    </Series>
                </Title>
                <Subject>
                    <xsl:for-each select="MetaData.Program.Subject.Class">
                        <Class>
                            <Classification>
                                <xsl:value-of select="MetaData.Program.Subject.Class.Classification"/>
                            </Classification>
                            <ClassNumber>
                                <xsl:value-of select="MetaData.Program.Subject.Class.ClassNumber"/>
                            </ClassNumber>
                        </Class>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Subject.SubjectTerm">
                        <SubjectTerm>
                            <xsl:value-of select="current()"/>
                        </SubjectTerm>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Subject.Keyword">
                        <Keyword>
                            <xsl:value-of select="current()"/>
                        </Keyword>
                    </xsl:for-each>
                </Subject>
                <Description>
                    <DescriptionofContent>
                        <xsl:value-of select="MetaData.Program.Description.DescriptionofContent"/>
                    </DescriptionofContent>
                    <xsl:for-each select="MetaData.Program.Description.Character">
                        <Character>
                            <xsl:value-of select="current()"/>
                        </Character>
                    </xsl:for-each>
                    <DateofEvent>
                        <xsl:value-of select="MetaData.Program.Description.DateofEvent"/>
                    </DateofEvent>
                    <xsl:for-each select="MetaData.Program.Description.VersionDescription">
                        <VersionDescription>
                            <xsl:value-of select="current()"/>
                        </VersionDescription>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Description.Awards">
                        <Awards>
                            <NameofAwards>
                                <xsl:value-of select="MetaData.Program.Description.Awards.NameofAwards"/>
                            </NameofAwards>
                            <ItemofAwards>
                                <xsl:value-of select="MetaData.Program.Description.Awards.ItemofAwards"/>
                            </ItemofAwards>
                            <xsl:for-each select="MetaData.Program.Description.Awards.WinnersofAwards">
                                <WinnersofAwards>
                                    <xsl:value-of select="current()"/>
                                </WinnersofAwards>
                            </xsl:for-each>
                            <YearorTimeofAwards>
                                <xsl:value-of select="MetaData.Program.Description.Awards.YearorTimeofAwards"/>
                            </YearorTimeofAwards>
                            <DateofAwards>
                                <xsl:value-of select="MetaData.Program.Description.Awards.DateofAwards"/>
                            </DateofAwards>
                        </Awards>
                    </xsl:for-each>

                    <xsl:for-each select="MetaData.Program.Description.Column">
                        <Column>
                            <ColumnName>
                                <xsl:value-of select="MetaData.Program.Description.Column.ColumnName"/>
                            </ColumnName>
                            <IssueNumber>
                                <xsl:value-of select="MetaData.Program.Description.Column.IssueNumber"/>
                            </IssueNumber>
                            <IssueYear>
                                <xsl:value-of select="MetaData.Program.Description.Column.IssueYear"/>
                            </IssueYear>
                        </Column>
                    </xsl:for-each>
                    <Audience>
                        <xsl:value-of select="MetaData.Program.Description.Audience"/>
                    </Audience>
                    <AdditionalLogo>
                        <xsl:value-of select="MetaData.Program.Description.AdditionalLogo"/>
                    </AdditionalLogo>
                    <xsl:for-each select="MetaData.Program.Description.AudioChannel">
                        <AudioChannel>
                            <AudioChannelNumber>
                                <xsl:value-of select="MetaData.Program.Description.AudioChannel.AudioChannelNumber"/>
                            </AudioChannelNumber>
                            <AudioChannelDescription>
                                <xsl:value-of select="MetaData.Program.Description.AudioChannel.AudioChannelDescription"/>
                            </AudioChannelDescription>
                        </AudioChannel>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Description.Attachment">
                        <Attachment>
                            <xsl:value-of select="current()"/>
                        </Attachment>
                    </xsl:for-each>
                </Description>
                <Creator>
                    <xsl:for-each select="MetaData.Program.Creator.DescriptionofCreator">
                        <DescriptionofCreator>
                            <NameofCreator>
                                <xsl:value-of select="MetaData.Program.Creator.DescriptionofCreator.NameofCreator"/>
                            </NameofCreator>
                            <xsl:for-each select="MetaData.Program.Creator.DescriptionofCreator.ParallelNameofCreator">
                                <ParallelNameofCreator>
                                    <xsl:value-of select="current()"/>
                                </ParallelNameofCreator>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="MetaData.Program.Creator.DescriptionofCreator.Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="MetaData.Program.Creator.DescriptionofCreator.OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofCreator>
                    </xsl:for-each>
                </Creator>
                <Contributor>
                    <xsl:for-each select="MetaData.Program.Contributor.DescriptionofContributor">
                        <DescriptionofContributor>
                            <NameofContributor>
                                <xsl:value-of select="MetaData.Program.Contributor.DescriptionofContributor.NameofContributor"/>
                            </NameofContributor>
                            <xsl:for-each select="MetaData.Program.Contributor.DescriptionofContributor.ParallelNameofContributor">
                                <ParallelNameofContributor>
                                    <xsl:value-of select="current()"/>
                                </ParallelNameofContributor>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="MetaData.Program.Contributor.DescriptionofContributor.Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="MetaData.Program.Contributor.DescriptionofContributor.OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofContributor>
                    </xsl:for-each>
                </Contributor>
                <Publisher>
                    <xsl:for-each select="MetaData.Program.Publisher.DescriptionofPublisher">
                        <DescriptionofPublisher>
                            <NameofPublisher>
                                <xsl:value-of select="MetaData.Program.Publisher.DescriptionofPublisher.NameofPublisher"/>
                            </NameofPublisher>
                            <PlaceofPublication>
                                <xsl:value-of select="MetaData.Program.Publisher.DescriptionofPublisher.PlaceofPublication"/>
                            </PlaceofPublication>
                        </DescriptionofPublisher>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Publisher.DescriptionofProducer">
                        <DescriptionofProducer>
                            <NameofProducer>
                                <xsl:value-of select="MetaData.Program.Publisher.DescriptionofProducer.NameofProducer"/>
                            </NameofProducer>
                            <PlaceofProduction>
                                <xsl:value-of select="MetaData.Program.Publisher.DescriptionofProducer.PlaceofProduction"/>
                            </PlaceofProduction>
                        </DescriptionofProducer>
                    </xsl:for-each>
                </Publisher>
                <Copyright>
                    <xsl:for-each select="MetaData.Program.Copyright.DescriptionofAuthorizedUse">
                        <DescriptionofAuthorizedUse>
                            <TimesofAuthorizedUsage>
                                <xsl:value-of select="MetaData.Program.Copyright.DescriptionofAuthorizedUse.TimesofAuthorizedUsage"/>
                            </TimesofAuthorizedUsage>
                        </DescriptionofAuthorizedUse>
                    </xsl:for-each>
                </Copyright>
                <Language>
                    <xsl:for-each select="MetaData.Program.Language.AudioChannel">
                        <AudioChannel>
                            <AudioChannelNumber>
                                <xsl:value-of select="MetaData.Program.Language.AudioChannel.AudioChannelNumber"/>
                            </AudioChannelNumber>
                            <AudioChannelLanguage>
                                <xsl:value-of select="MetaData.Program.Language.AudioChannel.AudioChannelLanguage"/>
                            </AudioChannelLanguage>
                        </AudioChannel>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Language.Subtitle">
                        <Subtitle>
                            <SubtitleNumber>
                                <xsl:value-of select="MetaData.Program.Language.Subtitle.SubtitleNumber"/>
                            </SubtitleNumber>
                            <SubtitleLanguage>
                                <xsl:value-of select="MetaData.Program.Language.Subtitle.SubtitleLanguage"/>
                            </SubtitleLanguage>
                        </Subtitle>
                    </xsl:for-each>
                </Language>
                <Date>
                    <ProducedDate>
                        <xsl:value-of select="MetaData.Program.Date.ProducedDate"/>
                    </ProducedDate>
                    <DateofDebut>
                        <xsl:value-of select="MetaData.Program.Date.DateofDebut"/>
                    </DateofDebut>
                    <PublishedDate>
                        <xsl:value-of select="MetaData.Program.Date.PublishedDate"/>
                    </PublishedDate>
                </Date>
                <Type>
                    <xsl:for-each select="MetaData.Program.Type.ProgramType">
                        <ProgramType>
                            <xsl:value-of select="current()"/>
                        </ProgramType>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Type.ProgramForm">
                        <ProgramForm>
                            <xsl:value-of select="current()"/>
                        </ProgramForm>
                    </xsl:for-each>
                </Type>
                <Format>
                    <Duration>
                        <xsl:value-of select="MetaData.Program.Format.Duration"/>
                    </Duration>
                    <StartingPoint>
                        <xsl:value-of select="MetaData.Program.Format.StartingPoint"/>
                    </StartingPoint>
                    <Color>
                        <xsl:value-of select="MetaData.Program.Format.Color"/>
                    </Color>
                    <SubtitleForm>
                        <xsl:value-of select="MetaData.Program.Format.SubtitleForm"/>
                    </SubtitleForm>
                    <AudioChannelFormat>
                        <xsl:value-of select="MetaData.Program.Format.AudioChannelFormat"/>
                    </AudioChannelFormat>
                    <AudioQuality>
                        <xsl:value-of select="MetaData.Program.Format.AudioQuality"/>
                    </AudioQuality>
                    <VideoQuality>
                        <xsl:value-of select="MetaData.Program.Format.VideoQuality"/>
                    </VideoQuality>
                    <AspectRatio>
                        <xsl:value-of select="MetaData.Program.Format.AspectRatio"/>
                    </AspectRatio>
                    <PhysicalMediaType>
                        <xsl:value-of select="MetaData.Program.Format.PhysicalMediaType"/>
                    </PhysicalMediaType>
                    <System>
                        <xsl:value-of select="MetaData.Program.Format.System"/>
                    </System>
                    <AudioDataRate>
                        <xsl:value-of select="MetaData.Program.Format.AudioDataRate"/>
                    </AudioDataRate>
                    <AudioCodingFormat>
                        <xsl:value-of select="MetaData.Program.Format.AudioCodingFormat"/>
                    </AudioCodingFormat>
                    <AudioSamplingFrequency>
                        <xsl:value-of select="MetaData.Program.Format.AudioSamplingFrequency"/>
                    </AudioSamplingFrequency>
                    <AudioBitDepth>
                        <xsl:value-of select="MetaData.Program.Format.AudioBitDepth"/>
                    </AudioBitDepth>
                    <VideoBitrate>
                        <xsl:value-of select="MetaData.Program.Format.VideoBitrate"/>
                    </VideoBitrate>
                    <VideoCodingFormat>
                        <xsl:value-of select="MetaData.Program.Format.VideoCodingFormat"/>
                    </VideoCodingFormat>
                    <VideoSamplingType>
                        <xsl:value-of select="MetaData.Program.Format.VideoSamplingType"/>
                    </VideoSamplingType>
                    <FileFormat>
                        <xsl:value-of select="MetaData.Program.Format.FileFormat"/>
                    </FileFormat>
                </Format>
                <Coverage>
                    <xsl:for-each select="MetaData.Program.Coverage.YearsCovered">
                        <YearsCovered>
                            <YearofStart>
                                <xsl:value-of select="MetaData.Program.Coverage.YearsCovered.YearofStart"/>
                            </YearofStart>
                            <YearofEnd>
                                <xsl:value-of select="MetaData.Program.Coverage.YearsCovered.YearofEnd"/>
                            </YearofEnd>
                        </YearsCovered>
                    </xsl:for-each>
                    <xsl:for-each select="MetaData.Program.Coverage.Spatial">
                        <Spatial>
                            <xsl:value-of select="current()"/>
                        </Spatial>
                    </xsl:for-each>
                </Coverage>
            </Program>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>